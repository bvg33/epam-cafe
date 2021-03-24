package com.epam.web.dao.extractor;

import com.epam.web.entity.Bucket;
import com.epam.web.entity.Menu;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MenuFieldExtractorTest {
    private final EntityFieldExtractor<Menu>extractor=new MenuFieldExtractor();

    @Test
    public void testMenuFieldExtractorShouldExtractWhenBucketIsCorrectAndMapsShouldEquals(){
        Menu menu=new Menu(1,"name","5","photo",0);
        Map<String,String> actual=extractor.parse(menu);
        Map<String,String>expected=createExpectedMap();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testMenuFieldExtractorShouldExtractWhenBucketIsCorrectAndMapsShouldNotEquals(){
        Menu menu=new Menu(1,"name","5","photo",1);
        Map<String,String> actual=extractor.parse(menu);
        Map<String,String>expected=createExpectedMap();
        Assert.assertNotEquals(expected,actual);
    }

    private Map<String,String> createExpectedMap(){
        Map<String,String>expected=new HashMap<>();
        expected.put("is_active","0");
        expected.put("id","1");
        expected.put("name","name");
        expected.put("price","5");
        expected.put("photo","photo");
        return expected;
    }
}
