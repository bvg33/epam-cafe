package com.epam.web.logic.service;

import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.menudao.MenuDaoImpl;
import com.epam.web.dao.userdao.UserDao;
import com.epam.web.entity.Menu;

import java.util.ArrayList;
import java.util.List;

public class OrderPageService {
    private DaoHelperFactory daoHelperFactory;

    public OrderPageService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public List<Menu> getMenuFromBd() {
        List<Menu> result = new ArrayList<>();
        try (DaoHelper daoHelper = daoHelperFactory.createDaoHelper()) {
            MenuDaoImpl dao = daoHelper.createMenuDao();
            result = dao.getAll(Menu.TABLE);
        } catch (Exception e) {
            //todo log
        }
        return result;
    }
}
