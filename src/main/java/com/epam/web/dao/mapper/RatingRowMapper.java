package com.epam.web.dao.mapper;

import com.epam.web.entity.Rating;
import com.epam.web.exceptions.DaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class RatingRowMapper implements RowMapper<Rating> {
    private static final String ID="id";
    private static final String ORDER_ID="order_id";
    private static final String STARS="stars";
    @Override
    public Rating map(ResultSet resultSet) throws DaoException, SQLException {
        int id = resultSet.getInt(ID);
        int orderId = resultSet.getInt(ORDER_ID);
        int stars = resultSet.getInt(STARS);
        return new Rating(id, orderId, stars);
    }


}
