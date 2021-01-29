package com.epam.web.dao.mapper;

import com.epam.web.entity.Menu;
import com.epam.web.exceptions.DaoException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Mockito.when;

public class MenuRowMapperTest {
    private final MenuRowMapper mapper=new MenuRowMapper();
    @Test
    public void testMapShouldReturnMenuWhenDataIsCorrect() throws SQLException, DaoException {
        ResultSet resultSet= Mockito.mock(ResultSet.class);
        when(resultSet.getInt("id")).thenReturn(1);
        when(resultSet.getString("name")).thenReturn("name");
        when(resultSet.getString("price")).thenReturn("2 BYN");
        when(resultSet.getString("photo")).thenReturn("photo");
        when(resultSet.getInt("is_active")).thenReturn(1);
        Menu actual=mapper.map(resultSet);
        Menu expected=new Menu(1,"name","2 BYN","photo",1);
        Assert.assertEquals(expected,actual);
    }
}
