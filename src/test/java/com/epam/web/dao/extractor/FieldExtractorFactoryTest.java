package com.epam.web.dao.extractor;

import com.epam.web.entity.*;
import org.junit.Assert;
import org.junit.Test;

public class FieldExtractorFactoryTest {
    @Test
    public void testCreateFieldExtractorShouldReturnUserFieldExtractorWhenTableNameIsUser(){
        EntityFieldExtractor<User> actual=FieldExtractorFactory.createFieldExtractor(User.TABLE);
        EntityFieldExtractor<User> expected=new UserFieldExtractor();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testCreateFieldExtractorShouldReturnMenuFieldExtractorWhenTableNameIsMenu(){
        EntityFieldExtractor<Menu> actual=FieldExtractorFactory.createFieldExtractor(Menu.TABLE);
        EntityFieldExtractor<Menu> expected=new MenuFieldExtractor();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testCreateFieldExtractorShouldReturnOrderFieldExtractorWhenTableNameIsOrder(){
        EntityFieldExtractor<Order> actual=FieldExtractorFactory.createFieldExtractor(Order.TABLE);
        EntityFieldExtractor<Order> expected=new OrderFieldExtractor();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testCreateFieldExtractorShouldReturnBucketFieldExtractorWhenTableNameIsBucket(){
        EntityFieldExtractor<Bucket> actual=FieldExtractorFactory.createFieldExtractor(Bucket.TABLE);
        EntityFieldExtractor<Bucket> expected=new BucketFieldExtractor();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testCreateFieldExtractorShouldReturnRatingFieldExtractorWhenTableNameIsRating(){
        EntityFieldExtractor<Rating> actual=FieldExtractorFactory.createFieldExtractor(Rating.TABLE);
        EntityFieldExtractor<Rating> expected=new RatingFieldExtractor();
        Assert.assertEquals(expected,actual);
    }
}
