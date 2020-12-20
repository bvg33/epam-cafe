package com.epam.web.dao.userdao;

import com.epam.web.dao.Dao;
import com.epam.web.entity.User;
import com.epam.web.exceptions.DaoException;

import java.util.Optional;

public interface UserDao extends Dao<User> {
    Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException;
    Optional<User> findUserByLogin(String login) throws DaoException;
}

