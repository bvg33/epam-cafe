package com.epam.web.connection;

import com.epam.web.exceptions.ConnectionException;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private Queue<ProxyConnection> availableConnections;
    private Queue<ProxyConnection> connectionsInUse;
    private static final ReentrantLock LOCK = new ReentrantLock();
    private static AtomicBoolean instanceCreated = new AtomicBoolean(false);
    private static ConnectionPool instance;
    private static final int POOL_SIZE = 10;

    private ConnectionPool()  {
        availableConnections = new ArrayDeque<>(POOL_SIZE);
        connectionsInUse = new ArrayDeque<>(POOL_SIZE);
        for (int i = 0; i < POOL_SIZE; i++) {
            ProxyConnection connection = ConnectionFactory.createConnection();
            availableConnections.offer(connection);
        }
    }

    public static ConnectionPool getInstance() {
        if (!instanceCreated.get()) {
            LOCK.lock();
            if (!instanceCreated.get()) {
                instance = new ConnectionPool();
                instanceCreated.set(true);
            }
            LOCK.unlock();
        }
        return instance;
    }

    public void releaseConnection(ProxyConnection proxyConnection) {
        LOCK.lock();
        try {
            if (connectionsInUse.contains(proxyConnection)) {
                availableConnections.offer(proxyConnection);
                connectionsInUse.remove(proxyConnection);
            }
        } finally {
            LOCK.unlock();
        }
    }

    public ProxyConnection getConnection() {
        ProxyConnection toReturn = availableConnections.remove();
        connectionsInUse.add(toReturn);
        return toReturn;
    }

    public void destroy() throws ConnectionException {
        for (ProxyConnection connection : getInstance().connectionsInUse) {
            this.releaseConnection(connection);
        }
        for (ProxyConnection connection : getInstance().availableConnections) {
            connection.closeConnection();
        }
        //todo deregister driver
    }
}
