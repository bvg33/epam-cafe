package com.epam.web.logic.service;

import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.userdao.UserDao;
import com.epam.web.entity.Role;
import com.epam.web.entity.User;
import com.epam.web.exceptions.DaoException;

import java.util.List;
import java.util.Objects;

public class GoToAdminPageService {
    private DaoHelperFactory daoHelperFactory;

    public GoToAdminPageService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public List<User> findUsers() throws DaoException {
        try (DaoHelper daoHelper = daoHelperFactory.createDaoHelper()) {
            UserDao dao = daoHelper.createUserDao();
            return dao.findUsersByRole("user");
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
