package com.epam.web.dao.extractor;

import com.epam.web.entity.Rating;
import com.epam.web.entity.Role;
import com.epam.web.entity.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class UserFieldExtractorTest {
    private final EntityFieldExtractor<User>extractor=new UserFieldExtractor();

    @Test
    public void testUserFieldExtractorShouldExtractWhenBucketIsCorrectAndMapsShouldEquals(){
        User user=new User(1,"login","password","name","123",34, Role.USER);
        Map<String,String> actual=extractor.parse(user);
        Map<String,String> expected=createExpectedMap();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testUserFieldExtractorShouldExtractWhenBucketIsCorrectAndMapsShouldNotEquals(){
        User user=new User(1,"login","password","name","123",10, Role.USER);
        Map<String,String> actual=extractor.parse(user);
        Map<String,String> expected=createExpectedMap();
        Assert.assertNotEquals(expected,actual);
    }
    private Map<String,String> createExpectedMap(){
        Map<String,String>expected=new HashMap<>();
        expected.put("password","password");
        expected.put("login","login");
        expected.put("name","name");
        expected.put("cardNumber","123");
        expected.put("id","1");
        expected.put("points","34");
        expected.put("role","USER");
        return expected;
    }
}
