package com.epam.web.logic.service;

import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.orderdtodao.OrderDtoDaoImpl;
import com.epam.web.dto.OrderDto;
import com.epam.web.exceptions.DaoException;

import java.util.List;

public class GoToMyOrdersPageService {
    private final DaoHelperFactory daoHelperFactory;
    public GoToMyOrdersPageService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public List<OrderDto> getAllUsersOrdersDto(int id) throws DaoException {
        try (DaoHelper daoHelper=daoHelperFactory.createDaoHelper()) {
            OrderDtoDaoImpl dao=daoHelper.createOrderDtoDao();
            List<OrderDto> result=dao.getUserOrders(id);
            return result;
        }
    }
}
