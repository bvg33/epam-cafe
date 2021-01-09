package com.epam.web.dao.orderdao;

import com.epam.web.dao.Dao;
import com.epam.web.entity.Order;
import com.epam.web.exceptions.DaoException;

import java.util.List;

public interface OrderDao extends Dao<Order> {
    List<Order> getUsersOrders (int userId) throws DaoException;
}
