package com.epam.web.dao.mapper;

import com.epam.web.entity.Rating;
import com.epam.web.exceptions.DaoException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Mockito.when;

public class RatingRowMapperTest {
    private final RatingRowMapper mapper=new RatingRowMapper();
    @Test
    public void testMapShouldReturnRatingWhenDataIsCorrect() throws SQLException, DaoException {
        ResultSet resultSet= Mockito.mock(ResultSet.class);
        when(resultSet.getInt("id")).thenReturn(1);
        when(resultSet.getInt("order_id")).thenReturn(1);
        when(resultSet.getInt("stars")).thenReturn(5);
        Rating actual=mapper.map(resultSet);
        Rating expected=new Rating(1,1,5);
        Assert.assertEquals(expected,actual);
    }
}
