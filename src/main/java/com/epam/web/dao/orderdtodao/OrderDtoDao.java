package com.epam.web.dao.orderdtodao;

import com.epam.web.dto.OrderDto;
import com.epam.web.exceptions.DaoException;

import java.util.List;

public interface OrderDtoDao {
    List<OrderDto> getUserOrders(int id) throws DaoException;
}
