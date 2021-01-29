package com.epam.web.dao.mapper;

import com.epam.web.entity.*;
import org.junit.Assert;
import org.junit.Test;

public class RowMapperFactoryTest {
    @Test
    public void testCreateMapperShouldReturnUserRowMapperWhenTableNameIsUser(){
        RowMapper<User> actual=RowMapperFactory.createMapper(User.TABLE);
        Assert.assertEquals(UserRowMapper.class,actual.getClass());
    }
    @Test
    public void testCreateMapperShouldReturnMenuRowMapperWhenTableNameIsMenu(){
        RowMapper<Menu> actual=RowMapperFactory.createMapper(Menu.TABLE);
        Assert.assertEquals(MenuRowMapper.class,actual.getClass());
    }
    @Test
    public void testCreateMapperShouldReturnOrderRowMapperWhenTableNameIsOrder(){
        RowMapper<Order> actual=RowMapperFactory.createMapper(Order.TABLE);
        Assert.assertEquals(OrderRowMapper.class,actual.getClass());
    }
    @Test
    public void testCreateMapperShouldReturnBucketRowMapperWhenTableNameIsBucket(){
        RowMapper<Bucket> actual=RowMapperFactory.createMapper(Bucket.TABLE);
        Assert.assertEquals(BucketRowMapper.class,actual.getClass());
    }
    @Test
    public void testCreateMapperShouldReturnRatingRowMapperWhenTableNameIsRating(){
        RowMapper<Rating> actual=RowMapperFactory.createMapper(Rating.TABLE);
        Assert.assertEquals(RatingRowMapper.class,actual.getClass());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCreateMapperShouldThrowExceptionWhenTableNameIsNotCorrect() {
        RowMapperFactory.createMapper("test");
    }
}
