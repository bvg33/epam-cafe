package com.epam.web.logic.service;

import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.userdao.UserDao;
import com.epam.web.entity.User;
import com.epam.web.exceptions.DaoException;

import java.util.Objects;
import java.util.Optional;

public class UpdateLoyalityService {
    private final DaoHelperFactory daoHelperFactory;

    public UpdateLoyalityService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public void updateLoyality(User newUserInfo) throws DaoException {
        try (DaoHelper daoHelper=daoHelperFactory.createDaoHelper()) {
            UserDao dao = daoHelper.createUserDao();
            dao.save(newUserInfo);
        }
    }

    public User getUser(int id) throws DaoException {
        try (DaoHelper daoHelper=daoHelperFactory.createDaoHelper()) {
            UserDao dao = daoHelper.createUserDao();
            Optional<User> optionalUser = dao.getById(id);
            return optionalUser.get();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(daoHelperFactory);
    }
}
