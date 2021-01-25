package com.epam.web.dao;


import com.epam.web.exceptions.DaoException;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Dao <T>{
    /**
     *
     * Method to get Entity from date base by ID
     * @param id id of object in data base
     * @return
     * @throws DaoException
     */
    Optional<T> getById(int id) throws DaoException;

    /**
     *
     * Method to get all entities from data base by ID
     * @return
     * @throws DaoException
     */
    List<T> getAll() throws DaoException;

    /**
     *
     * Method to save entity into data base
     * @param item entity to be saved
     * @throws DaoException
     */
    void save(T item) throws  DaoException;

    /**
     *
     * method to remove entity from data base by id
     * @param id id of object in data base
     * @throws DaoException
     */
    void removeById(Long id) throws DaoException;
}
