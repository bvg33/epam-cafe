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

public class UpdateLoyalityService {
    private final DaoHelperFactory daoHelperFactory;

    public UpdateLoyalityService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public void updateLoyality(User newUserInfo) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.createDaoHelper()) {
            UserDao dao = daoHelper.createUserDao();
            dao.save(newUserInfo);
        } catch (DaoException | ConnectionException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public User getUser(int id) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.createDaoHelper()) {
            UserDao dao = daoHelper.createUserDao();
            Optional<User> optionalUser = null;
            optionalUser = dao.getById(id);
            return optionalUser.get();
        } catch (DaoException | ConnectionException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
