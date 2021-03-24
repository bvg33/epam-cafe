package com.epam.web.dao.extractor;

import com.epam.web.entity.Order;
import com.epam.web.entity.Rating;
import com.epam.web.enums.OrderStateEnum;
import com.epam.web.enums.OrderTypeEnum;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class RatingFieldExtractorTest {
    private final EntityFieldExtractor<Rating>extractor=new RatingFieldExtractor();

    @Test
    public void testRatingFieldExtractorShouldExtractWhenBucketIsCorrectAndMapsShouldEquals(){
        Rating rating=new Rating(1,1,1);
        Map<String,String> actual=extractor.parse(rating);
        Map<String,String> expected=createExpectedMap();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testRatingFieldExtractorShouldExtractWhenBucketIsCorrectAndMapsShouldNotEquals(){
        Rating rating=new Rating(1,1,2);
        Map<String,String> actual=extractor.parse(rating);
        Map<String,String> expected=createExpectedMap();
        Assert.assertNotEquals(expected,actual);
    }
    private Map<String,String> createExpectedMap(){
        Map<String,String>expected=new HashMap<>();
        expected.put("id","1");
        expected.put("order_id","1");
        expected.put("stars","1");
        return expected;
    }
}
