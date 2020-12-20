package com.epam.web.dao.mapper;

import com.epam.web.entity.Menu;
import com.epam.web.entity.User;
import com.epam.web.exceptions.DaoException;
import com.sun.corba.se.spi.ior.Identifiable;

import java.sql.ResultSet;

public interface RowMapper <T extends Identifiable> {
    T map(ResultSet resultSet) throws DaoException;
    static RowMapper createMapper(String tableName){ //todo factory method
        switch (tableName){
            case User.TABLE :return new UserRowMapper();
            case Menu.TABLE:return new MenuRowMapper();
            default:throw new IllegalArgumentException("Unknown table "+tableName);
        }
    }

}
