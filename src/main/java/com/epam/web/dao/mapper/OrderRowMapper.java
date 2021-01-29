package com.epam.web.dao.mapper;

import com.epam.web.entity.Order;
import com.epam.web.enums.OrderStateEnum;
import com.epam.web.enums.OrderTypeEnum;
import com.epam.web.exceptions.DaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class OrderRowMapper implements RowMapper<Order> {
    private static final String ID="id";
    private static final String PRICE="price";
    private static final String STATE="state";
    private static final String TIME="time";
    private static final String TYPE="type";
    private static final String USER_ID="user_id";
    @Override
    public Order map(ResultSet resultSet) throws DaoException {
        Order order = null;
        try {
            int id = resultSet.getInt(ID);
            String price = resultSet.getString(PRICE);
            String time = resultSet.getString(TIME);
            int user_id = resultSet.getInt(USER_ID);
            String typeString = resultSet.getString(TYPE);
            OrderTypeEnum type = OrderTypeEnum.valueOf(typeString.toUpperCase());
            String stateString = resultSet.getString(STATE);
            OrderStateEnum state = OrderStateEnum.valueOf(stateString.toUpperCase());
            order = new Order(id, price, type, state, time, user_id);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
        return order;
    }

}
