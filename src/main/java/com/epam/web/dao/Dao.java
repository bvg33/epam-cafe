package com.epam.web.dao;


import com.epam.web.exceptions.DaoException;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Dao <T>{
    Optional<T> getById(Long id);
    List<T> getAll(String tableName) throws DaoException;
    void save(T item) throws SQLException, DaoException;
    void removeById(Long id);
}
