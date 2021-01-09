package com.epam.web.dao.helper;

import com.epam.web.connection.ConnectionPool;
import com.epam.web.connection.ProxyConnection;
import com.epam.web.dao.bucketdao.BucketDao;
import com.epam.web.dao.menudao.MenuDaoImpl;
import com.epam.web.dao.orderdao.OrderDaoImpl;
import com.epam.web.dao.orderdtodao.OrderDtoDaoImpl;
import com.epam.web.dao.userdao.UserDao;
import com.epam.web.dao.userdao.UserDaoImpl;
import com.epam.web.exceptions.ConnectionException;

public class DaoHelper implements AutoCloseable {
    private ProxyConnection connection;

    public DaoHelper(ConnectionPool pool) {
        this.connection = pool.getConnection();
    }

    public UserDao createUserDao() {
        return new UserDaoImpl(connection);
    }

    public MenuDaoImpl createMenuDao() {
        return new MenuDaoImpl(connection);
    }

    public OrderDaoImpl createOrderDao() {
        return new OrderDaoImpl(connection);
    }

    public BucketDao createBucketDao() {
        return new BucketDao(connection);
    }

    public OrderDtoDaoImpl createOrderDtoDao(){return new OrderDtoDaoImpl(connection);}

    @Override
    public void close() {
        connection.close();
    }

    public void startTransaction() throws ConnectionException {
        connection.setAutoCommit(false);
    }

    public void commit() throws ConnectionException {
        connection.commit();
    }

    public void rollBack() throws ConnectionException {
        connection.rollback();
    }

    public void endTransaction() throws ConnectionException {
        connection.setAutoCommit(true);
    }
}
