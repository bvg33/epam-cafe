package com.epam.web.logic.service;

import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.orderdtodao.OrderDtoDaoImpl;
import com.epam.web.dao.userdao.UserDao;
import com.epam.web.dto.OrderDto;
import com.epam.web.exceptions.DaoException;

import java.util.List;

public class GoToAllOrdersPageService {
    private final DaoHelperFactory daoHelperFactory;

    public GoToAllOrdersPageService(DaoHelperFactory helper) {
        this.daoHelperFactory = helper;
    }

    public List<OrderDto> getAllOrders() throws DaoException {
        try (DaoHelper daoHelper=daoHelperFactory.createDaoHelper()) {
            OrderDtoDaoImpl dao=daoHelper.createOrderDtoDao();
            return dao.getAll();
        }
    }
}
