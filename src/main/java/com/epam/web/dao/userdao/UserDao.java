package com.epam.web.dao.userdao;

import com.epam.web.dao.Dao;
import com.epam.web.entity.User;
import com.epam.web.exceptions.DaoException;

import java.util.List;
import java.util.Optional;

public interface UserDao extends Dao<User> {
    Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException;
    Optional<User> findUserByLogin(String login) throws DaoException;
    List<User> findUsersByRole(String role) throws DaoException;
   /* void updateUserNameLoginCardNumber(int id,String newName,String newLogin,String newCardNumber) throws DaoException;
    void updateUserLoyality(int id,int loyality) throws DaoException;*/
}

