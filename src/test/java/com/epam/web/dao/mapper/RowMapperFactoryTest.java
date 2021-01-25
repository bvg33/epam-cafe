package com.epam.web.dao.mapper;

import com.epam.web.entity.*;
import org.junit.Assert;
import org.junit.Test;

public class RowMapperFactoryTest {
    @Test
    public void testCreateMapperShouldReturnUserRowMapperWhenTableNameIsUser(){
        RowMapper<User> actual=RowMapperFactory.createMapper(User.TABLE);
        RowMapper<User> expected=new UserRowMapper();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testCreateMapperShouldReturnMenuRowMapperWhenTableNameIsMenu(){
        RowMapper<Menu> actual=RowMapperFactory.createMapper(Menu.TABLE);
        RowMapper<Menu> expected=new MenuRowMapper();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testCreateMapperShouldReturnOrderRowMapperWhenTableNameIsOrder(){
        RowMapper<Order> actual=RowMapperFactory.createMapper(Order.TABLE);
        RowMapper<Order> expected=new OrderRowMapper();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testCreateMapperShouldReturnBucketRowMapperWhenTableNameIsBucket(){
        RowMapper<Bucket> actual=RowMapperFactory.createMapper(Bucket.TABLE);
        RowMapper<Bucket> expected=new BucketRowMapper();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testCreateMapperShouldReturnRatingRowMapperWhenTableNameIsRating(){
        RowMapper<Rating> actual=RowMapperFactory.createMapper(Rating.TABLE);
        RowMapper<Rating> expected=new RatingRowMapper();
        Assert.assertEquals(expected,actual);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCreateMapperShouldThrowExceptionWhenTableNameIsNotCorrect() {
        RowMapperFactory.createMapper("test");
    }
}
