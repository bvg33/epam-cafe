package com.epam.web.logic.service;

import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.orderdtodao.OrderDtoDao;
import com.epam.web.dao.orderdtodao.OrderDtoDaoImpl;
import com.epam.web.dao.userdao.UserDao;
import com.epam.web.dto.OrderDto;
import com.epam.web.exceptions.DaoException;

import java.util.List;
import java.util.Objects;

public class GoToAllOrdersPageService {
    private final DaoHelperFactory daoHelperFactory;

    public GoToAllOrdersPageService(DaoHelperFactory helper) {
        this.daoHelperFactory = helper;
    }

    public List<OrderDto> getAllOrders() throws DaoException {
        try (DaoHelper daoHelper=daoHelperFactory.createDaoHelper()) {
            OrderDtoDao dao=daoHelper.createOrderDtoDao();
            return dao.getAllUncollectedOrders();
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
