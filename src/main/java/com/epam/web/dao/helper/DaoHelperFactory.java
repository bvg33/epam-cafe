package com.epam.web.dao.helper;

import com.epam.web.connection.ConnectionPool;
import com.epam.web.exceptions.ConnectionException;

public class DaoHelperFactory {
    public DaoHelper createDaoHelper() throws ConnectionException {
        return new DaoHelper(ConnectionPool.getInstance());
    }

}