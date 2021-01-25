package com.epam.web.dao.orderdtodao;

import com.epam.web.dto.OrderDto;
import com.epam.web.exceptions.DaoException;

import java.util.List;

public interface OrderDtoDao {
    /**
     * Method to get all order dtos ordered by user
     * @param id ID of order entity in data base
     * @return List of OrderDto
     * @throws DaoException
     */
    List<OrderDto> getUserOrders(int id) throws DaoException;

    /**
     * Method to get all uncollected order dtos
     * @return List of OrderDto
     * @throws DaoException
     */
    List<OrderDto> getAllUncollectedOrders()throws DaoException;

    /**
     * Method to get all collected order dtos
     * @return List of OrderDto
     * @throws DaoException
     */
    List<OrderDto> getAllCollectedOrders() throws DaoException;

}
