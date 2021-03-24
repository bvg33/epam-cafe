package com.epam.web.dao.orderdao;

import com.epam.web.dao.Dao;
import com.epam.web.entity.Order;
import com.epam.web.exceptions.DaoException;

import java.util.List;

public interface OrderDao extends Dao<Order> {
    /**
     * Method to get user's orders
     * @param userId id of user that make orders
     * @return List of Orders
     * @throws DaoException
     */
    List<Order> getUsersOrders (int userId) throws DaoException;
}
