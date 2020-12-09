package com.epam.web.dao.helper;

import com.epam.web.connection.ConnectionPool;
import com.epam.web.connection.ProxyConnection;
import com.epam.web.dao.userdao.UserDao;
import com.epam.web.dao.userdao.UserDaoImpl;
import com.epam.web.exceptions.DaoException;

import java.sql.SQLException;

public class DaoHelper implements AutoCloseable{
    private ProxyConnection connection;

    public DaoHelper(ConnectionPool pool) {
        this.connection = pool.getConnection();
    }

    public UserDao createUserDao(){
        return new UserDaoImpl(connection);
    }

    @Override
    public void close() throws Exception {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new DaoException("Close DAO exception ", e);
        }
    }
}
