package com.epam.web.dao.mapper;

import com.epam.web.entity.Menu;
import com.epam.web.entity.Order;
import com.epam.web.enums.OrderStateEnum;
import com.epam.web.enums.OrderTypeEnum;
import com.epam.web.exceptions.DaoException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Mockito.when;

public class OrderRowMapperTest {
    private final OrderRowMapper mapper=new OrderRowMapper();
    @Test
    public void testMapShouldReturnOrderWhenDataIsCorrect() throws SQLException, DaoException {
        ResultSet resultSet= Mockito.mock(ResultSet.class);
        when(resultSet.getInt("id")).thenReturn(1);
        when(resultSet.getString("price")).thenReturn("2 BYN");
        when(resultSet.getInt("user_id")).thenReturn(1);
        when(resultSet.getString("time")).thenReturn("22:43");
        when(resultSet.getString("type")).thenReturn("cash");
        when(resultSet.getString("state")).thenReturn("accept");
        Order actual=mapper.map(resultSet);
        Order expected=new Order(1,"2 BYN",OrderTypeEnum.CASH, OrderStateEnum.ACCEPT,"22:43",1);
        Assert.assertEquals(expected,actual);
    }
}
