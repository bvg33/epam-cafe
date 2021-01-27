package com.epam.web.logic.service;

import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.orderdao.OrderDao;
import com.epam.web.dao.userdao.UserDao;
import com.epam.web.entity.Order;
import com.epam.web.exceptions.ConnectionException;
import com.epam.web.exceptions.DaoException;
import com.epam.web.exceptions.ServiceException;

import java.util.Objects;
import java.util.Optional;

public class UpdateOrderStatusService {
    private final DaoHelperFactory daoHelperFactory;

    public UpdateOrderStatusService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public Order getCurrentOrder(int id) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.createDaoHelper()) {
            OrderDao dao = daoHelper.createOrderDao();
            Optional<Order> order = null;
            order = dao.getById(id);
            return order.get();
        } catch (DaoException | ConnectionException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

        public void updateOrder (Order newOrderInfo) throws ServiceException {
            try (DaoHelper daoHelper = daoHelperFactory.createDaoHelper()) {
                OrderDao dao = daoHelper.createOrderDao();
                dao.save(newOrderInfo);
            } catch (DaoException | ConnectionException e) {
                throw new ServiceException(e.getMessage(), e);
            }
        }
    }
