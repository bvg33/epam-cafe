package com.epam.web.dao.extractor;

import com.epam.web.entity.*;
import org.junit.Assert;
import org.junit.Test;

public class FieldExtractorFactoryTest {
    @Test
    public void testCreateFieldExtractorShouldReturnUserFieldExtractorWhenTableNameIsUser(){
        EntityFieldExtractor<User> actual=FieldExtractorFactory.createFieldExtractor(User.TABLE);
        Assert.assertEquals(UserFieldExtractor.class,actual.getClass());
    }
    @Test
    public void testCreateFieldExtractorShouldReturnMenuFieldExtractorWhenTableNameIsMenu(){
        EntityFieldExtractor<Menu> actual=FieldExtractorFactory.createFieldExtractor(Menu.TABLE);
        Assert.assertEquals(MenuFieldExtractor.class,actual.getClass());
    }
    @Test
    public void testCreateFieldExtractorShouldReturnOrderFieldExtractorWhenTableNameIsOrder(){
        EntityFieldExtractor<Order> actual=FieldExtractorFactory.createFieldExtractor(Order.TABLE);
        Assert.assertEquals(OrderFieldExtractor.class,actual.getClass());
    }
    @Test
    public void testCreateFieldExtractorShouldReturnBucketFieldExtractorWhenTableNameIsBucket(){
        EntityFieldExtractor<Bucket> actual=FieldExtractorFactory.createFieldExtractor(Bucket.TABLE);
        Assert.assertEquals(BucketFieldExtractor.class,actual.getClass());
    }
    @Test
    public void testCreateFieldExtractorShouldReturnRatingFieldExtractorWhenTableNameIsRating(){
        EntityFieldExtractor<Rating> actual=FieldExtractorFactory.createFieldExtractor(Rating.TABLE);
        Assert.assertEquals(RatingFieldExtractor.class,actual.getClass());
    }
}
