package com.epam.web.dao.helper;

import com.epam.web.connection.ConnectionPool;

public class DaoHelperFactory {
    public DaoHelper createDaoHelper(){
        return new DaoHelper(ConnectionPool.getInstance());
    }
}