package com.epam.web.dao;


import com.epam.web.exceptions.DaoException;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Dao <T>{
    Optional<T> getById(int id) throws DaoException;
    List<T> getAll() throws DaoException;
    void save(T item) throws  DaoException;
    void removeById(Long id) throws DaoException;
}
