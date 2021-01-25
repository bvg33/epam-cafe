package com.epam.web.dao.userdao;

import com.epam.web.dao.Dao;
import com.epam.web.entity.User;
import com.epam.web.exceptions.DaoException;

import java.util.List;
import java.util.Optional;

public interface UserDao extends Dao<User> {
    /**
     *
     * Method to find user by login and password in data base
     * @param login user's login
     * @param password user's password
     * @return optional of User
     * @throws DaoException
     */
    Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException;

    /**
     * Method to find user by login in data base
     * @param login user's login
     * @return optional of User
     * @throws DaoException
     */
    Optional<User> findUserByLogin(String login) throws DaoException;

    /**
     * Method to find users by role in data base
     * @param role user's role
     * @return List of users
     * @throws DaoException
     */
    List<User> findUsersByRole(String role) throws DaoException;
}

