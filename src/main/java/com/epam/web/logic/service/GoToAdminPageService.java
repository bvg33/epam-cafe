package com.epam.web.logic.service;

import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.userdao.UserDao;
import com.epam.web.entity.Role;
import com.epam.web.entity.User;
import com.epam.web.exceptions.DaoException;

import java.util.List;

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
    public boolean hasRoots(User user){
        return user.getRole()== Role.ADMIN;
    }
}
