package com.epam.web.logic.service;

import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.userdao.UserDao;
import com.epam.web.entity.User;

import java.util.Optional;

public class LoginService {
    private DaoHelperFactory daoHelperFactory;

    public LoginService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public Optional<User> login(String password, String login) {
        try (DaoHelper daoHelper=daoHelperFactory.createDaoHelper()) {
            UserDao dao=daoHelper.createUserDao();
            return dao.findUserByLoginAndPassword(login, password);
        } catch (Exception e) {
            //todo log
        }
        return Optional.empty();
    }
}
