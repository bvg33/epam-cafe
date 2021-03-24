package com.epam.web.logic.service;

import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.userdao.UserDao;
import com.epam.web.entity.User;
import com.epam.web.exceptions.ConnectionException;
import com.epam.web.exceptions.DaoException;
import com.epam.web.exceptions.ServiceException;

import java.util.Objects;
import java.util.Optional;

public class LoginService {
    private DaoHelperFactory daoHelperFactory;

    public LoginService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public Optional<User> login(String password, String login) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.createDaoHelper()) {
            UserDao dao = daoHelper.createUserDao();
            return dao.findUserByLoginAndPassword(login, password);
        } catch (DaoException | ConnectionException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
