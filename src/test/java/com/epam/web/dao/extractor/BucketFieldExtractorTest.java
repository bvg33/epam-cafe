package com.epam.web.dao.extractor;

import com.epam.web.entity.Bucket;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class BucketFieldExtractorTest {
    private final EntityFieldExtractor<Bucket>extractor=new BucketFieldExtractor();

    @Test
    public void testBucketFieldExtractorShouldExtractWhenBucketIsCorrectAndMapsShouldEquals(){
        Bucket bucket=new Bucket(1,1,1,1);
        Map<String,String> actual=extractor.parse(bucket);
        Map<String,String> expected=createExpectedMap();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testBucketFieldExtractorShouldExtractWhenBucketIsCorrectAndMapsShouldNotEquals(){
        Bucket bucket=new Bucket(1,1,1,2);
        Map<String,String> actual=extractor.parse(bucket);
        Map<String,String> expected=createExpectedMap();
        Assert.assertNotEquals(expected,actual);
    }

    private Map<String,String> createExpectedMap(){
        Map<String,String>expected=new HashMap<>();
        expected.put("dish_id","1");
        expected.put("id","1");
        expected.put("order_id","1");
        expected.put("count","1");
        return expected;
    }
}
