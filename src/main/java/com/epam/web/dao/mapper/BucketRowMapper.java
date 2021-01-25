package com.epam.web.dao.mapper;

import com.epam.web.entity.Bucket;
import com.epam.web.exceptions.DaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class BucketRowMapper implements RowMapper<Bucket> {
    @Override
    public Bucket map(ResultSet resultSet) throws DaoException {
        Bucket bucket=null;
        try {
            int id=resultSet.getInt("id");
            int orderNumber=resultSet.getInt("order_number");
            int dishId=resultSet.getInt("dish_id");
            int count=resultSet.getInt("count");
            bucket=new Bucket(id,dishId,orderNumber,count);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(),e);
        }
        return bucket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return true;
    }
}
