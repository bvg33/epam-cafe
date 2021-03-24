package com.epam.web.dao.mapper;

import com.epam.web.entity.Menu;
import com.epam.web.entity.User;
import com.epam.web.exceptions.DaoException;
import com.sun.corba.se.spi.ior.Identifiable;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper <T extends Identifiable> {
    /**
     *
     * Method to create entity from ResultSet
     * @param resultSet
     * @return Entity
     * @throws DaoException
     * @throws SQLException
     */
    T map(ResultSet resultSet) throws DaoException, SQLException;

}
