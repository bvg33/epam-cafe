package com.epam.web.dao.mapper;

import com.epam.web.entity.Rating;
import com.epam.web.exceptions.DaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class RatingRowMapper implements RowMapper<Rating> {

    @Override
    public Rating map(ResultSet resultSet) throws DaoException, SQLException {
        int id = resultSet.getInt("id");
        int orderId = resultSet.getInt("order_id");
        int stars = resultSet.getInt("stars");
        return new Rating(id, orderId, stars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return true;
    }

}
