package com.epam.web.logic.service;

import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.orderdao.OrderDao;
import com.epam.web.dao.userdao.UserDao;
import com.epam.web.entity.Order;
import com.epam.web.exceptions.DaoException;

import java.util.Objects;
import java.util.Optional;

public class UpdateOrderStatusService {
    private final DaoHelperFactory daoHelperFactory;

    public UpdateOrderStatusService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public Order getCurrentOrder(int id) throws DaoException {
        try (DaoHelper daoHelper=daoHelperFactory.createDaoHelper()) {
            OrderDao dao=daoHelper.createOrderDao();
            Optional<Order> order =dao.getById(id);
            return order.get();
        }
    }

    public void updateOrder(Order newOrderInfo) throws DaoException {
        try (DaoHelper daoHelper=daoHelperFactory.createDaoHelper()) {
            OrderDao dao=daoHelper.createOrderDao();
            dao.save(newOrderInfo);
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
