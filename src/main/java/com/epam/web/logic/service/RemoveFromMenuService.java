package com.epam.web.logic.service;

import com.epam.web.dao.Dao;
import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.menudao.MenuDaoImpl;
import com.epam.web.dao.userdao.UserDao;
import com.epam.web.entity.Menu;
import com.epam.web.exceptions.ConnectionException;
import com.epam.web.exceptions.DaoException;
import com.epam.web.exceptions.ServiceException;

import java.util.Objects;

public class RemoveFromMenuService {
    private final DaoHelperFactory daoHelperFactory;

    public RemoveFromMenuService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public void removeDish(int id) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.createDaoHelper()) {
            Dao dao = daoHelper.createMenuDao();
            dao.removeById((long) id);
        } catch (DaoException | ConnectionException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
