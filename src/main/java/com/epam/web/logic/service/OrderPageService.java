package com.epam.web.logic.service;

import com.epam.web.dao.Dao;
import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.menudao.MenuDaoImpl;
import com.epam.web.dao.userdao.UserDao;
import com.epam.web.entity.Menu;
import com.epam.web.exceptions.DaoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderPageService {
    private DaoHelperFactory daoHelperFactory;

    public OrderPageService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public List<Menu> getMenuFromBd() throws DaoException {
        List<Menu> result = new ArrayList<>();
        try (DaoHelper daoHelper = daoHelperFactory.createDaoHelper()) {
            Dao dao = daoHelper.createMenuDao();
            result = dao.getAll();
        }
        return result;
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
