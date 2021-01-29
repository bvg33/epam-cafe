package com.epam.web.dao.mapper;

import com.epam.web.entity.Bucket;
import com.epam.web.exceptions.DaoException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Mockito.when;

public class BucketRowMapperTest {
    private final BucketRowMapper mapper=new BucketRowMapper();
    @Test
    public void testMapShouldReturnBucketWhenDataIsCorrect() throws SQLException, DaoException {
        ResultSet resultSet= Mockito.mock(ResultSet.class);
        when(resultSet.getInt("id")).thenReturn(1);
        when(resultSet.getInt("order_number")).thenReturn(1);
        when(resultSet.getInt("dish_id")).thenReturn(1);
        when(resultSet.getInt("count")).thenReturn(1);
        Bucket actual=mapper.map(resultSet);
        Bucket expected=new Bucket(1,1,1,1);
        Assert.assertEquals(expected,actual);
    }
}
