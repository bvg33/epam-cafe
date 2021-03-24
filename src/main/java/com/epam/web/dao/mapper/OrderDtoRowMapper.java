package com.epam.web.dao.mapper;

import com.epam.web.dto.OrderDto;
import com.epam.web.enums.OrderStateEnum;
import com.epam.web.enums.OrderTypeEnum;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDtoRowMapper implements RowMapper<OrderDto> {
    private static final String PRICE="price";
    private static final String ORDER_ID="order_id";
    private static final String TIME="time";
    private static final String STATE="state";
    private static final String TYPE="type";
    private static final String LOGIN="login";
    private static final String STARS="stars";
    private static final String NAME="name";
    private static final String COUNT="count";
    private static final String COUNT_SEPARATOR=":";
    private static final String DISH_SEPARATOR=",";

    @Override
    public OrderDto map(ResultSet resultSet) throws SQLException {
        int price=resultSet.getInt(PRICE);
        int orderNumber=resultSet.getInt(ORDER_ID);
        String time= resultSet.getString(TIME);
        String stateString=resultSet.getString(STATE);
        String cashString=resultSet.getString(TYPE);
        String login=resultSet.getString(LOGIN);
        Integer rating=resultSet.getInt(STARS);
        OrderTypeEnum cash=OrderTypeEnum.valueOf(cashString.toUpperCase());
        OrderStateEnum state=OrderStateEnum.valueOf(stateString.toUpperCase());
        StringBuilder dish=new StringBuilder(resultSet.getString(NAME));
        dish.append(COUNT_SEPARATOR);
        dish.append(resultSet.getInt(COUNT)).append(DISH_SEPARATOR);
        while(resultSet.next() && resultSet.getInt(ORDER_ID)==orderNumber){
            dish.append(resultSet.getString(NAME)).append(COUNT_SEPARATOR).append(resultSet.getInt(COUNT)).append(DISH_SEPARATOR);
        }
        resultSet.previous();
        return new OrderDto(orderNumber,price,state,time,dish.toString(),cash,login,rating);
    }
}
