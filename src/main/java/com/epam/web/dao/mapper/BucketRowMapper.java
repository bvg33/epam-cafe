package com.epam.web.dao.mapper;

import com.epam.web.entity.Bucket;
import com.epam.web.exceptions.DaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class BucketRowMapper implements RowMapper<Bucket> {
    private static final String DISH_ID="dish_id";
    private static final String ID="id";
    private static final String ORDER_NUMBER="order_number";
    private static final String COUNT="count";
    @Override
    public Bucket map(ResultSet resultSet) throws DaoException {
        Bucket bucket=null;
        try {
            int id=resultSet.getInt(ID);
            int orderNumber=resultSet.getInt(ORDER_NUMBER);
            int dishId=resultSet.getInt(DISH_ID);
            int count=resultSet.getInt(COUNT);
            bucket=new Bucket(id,dishId,orderNumber,count);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(),e);
        }
        return bucket;
    }


}
