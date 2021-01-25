package com.epam.web.logic.service;

import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.userdao.UserDao;
import com.epam.web.entity.User;
import com.epam.web.exceptions.DaoException;

import java.util.Objects;
import java.util.Optional;

public class LoginService {
    private DaoHelperFactory daoHelperFactory;

    public LoginService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public Optional<User> login(String password, String login) throws DaoException {
        try (DaoHelper daoHelper=daoHelperFactory.createDaoHelper()) {
            UserDao dao=daoHelper.createUserDao();
            return dao.findUserByLoginAndPassword(login, password);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginService that = (LoginService) o;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(daoHelperFactory);
    }
}
