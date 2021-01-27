package com.epam.web.logic.service;

import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.orderdtodao.OrderDtoDao;
import com.epam.web.dao.orderdtodao.OrderDtoDaoImpl;
import com.epam.web.dao.userdao.UserDao;
import com.epam.web.dto.OrderDto;
import com.epam.web.exceptions.ConnectionException;
import com.epam.web.exceptions.DaoException;
import com.epam.web.exceptions.ServiceException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GoToPickedOrdersService {
    private final DaoHelperFactory daoHelperFactory;

    public GoToPickedOrdersService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public List<OrderDto> getPickedOrders() throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.createDaoHelper()) {
            OrderDtoDao dao = daoHelper.createOrderDtoDao();
            return dao.getAllCollectedOrders();
        } catch (DaoException | ConnectionException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
