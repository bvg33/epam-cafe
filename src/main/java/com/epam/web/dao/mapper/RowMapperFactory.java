package com.epam.web.dao.mapper;

import com.epam.web.dto.OrderDto;
import com.epam.web.entity.Bucket;
import com.epam.web.entity.Menu;
import com.epam.web.entity.Order;
import com.epam.web.entity.User;

public class RowMapperFactory {
    public static RowMapper createMapper(String tableName) {
        switch (tableName) {
            case User.TABLE:
                return new UserRowMapper();
            case Menu.TABLE:
                return new MenuRowMapper();
            case Order.TABLE:
                return new OrderRowMapper();
            case Bucket.TABLE:
                return new BucketRowMapper();
            case OrderDto.TABLE:
                return new OrderDtoRowMapper();
            default:
                throw new IllegalArgumentException("Unknown table " + tableName);
        }
    }
}
