package com.epam.web.dao.mapper;

import com.epam.web.entity.Order;
import com.epam.web.enums.OrderStateEnum;
import com.epam.web.enums.OrderTypeEnum;
import com.epam.web.exceptions.DaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class OrderRowMapper implements RowMapper<Order> {

    @Override
    public Order map(ResultSet resultSet) throws DaoException {
        Order order = null;
        try {
            int id = resultSet.getInt("id");
            String price = resultSet.getString("price");
            String time = resultSet.getString("time");
            int user_id = resultSet.getInt("user_id");
            String typeString = resultSet.getString("type");
            OrderTypeEnum type = OrderTypeEnum.valueOf(typeString.toUpperCase());
            String stateString = resultSet.getString("state");
            OrderStateEnum state = OrderStateEnum.valueOf(stateString.toUpperCase());
            order = new Order(id, price, type, state, time, user_id);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
        return order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return true;
    }
}
