package com.epam.web.dao.mapper;

import com.epam.web.dto.OrderDto;
import com.epam.web.enums.OrderStateEnum;
import com.epam.web.enums.OrderTypeEnum;
import com.epam.web.exceptions.DaoException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDtoRowMapper implements RowMapper<OrderDto> {

    @Override
    public OrderDto map(ResultSet resultSet) throws DaoException, SQLException {
        int price=resultSet.getInt("price");
        int orderNumber=resultSet.getInt("order_id");
        String time= resultSet.getString("time");
        String stateString=resultSet.getString("state");
        String cashString=resultSet.getString("type");
        String login=resultSet.getString("login");
        OrderTypeEnum cash=OrderTypeEnum.valueOf(cashString.toUpperCase());
        OrderStateEnum state=OrderStateEnum.valueOf(stateString.toUpperCase());
        StringBuilder dish=new StringBuilder(resultSet.getString("name"));
        dish.append(":");
        dish.append(resultSet.getInt("count")).append(";");
        while(resultSet.next() && resultSet.getInt("order_id")==orderNumber){
            int id=resultSet.getInt("id");
            dish.append(resultSet.getString("name")).append(":").append(resultSet.getInt("count")).append(";");
        }
        resultSet.previous();
        return new OrderDto(price,state,time,orderNumber,dish.toString(),cash,login);
    }
}
