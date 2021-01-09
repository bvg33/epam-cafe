package com.epam.web.dao.mapper;

import com.epam.web.entity.Menu;
import com.epam.web.entity.User;
import com.epam.web.exceptions.DaoException;
import com.sun.corba.se.spi.ior.Identifiable;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper <T extends Identifiable> {
    T map(ResultSet resultSet) throws DaoException, SQLException;

}
