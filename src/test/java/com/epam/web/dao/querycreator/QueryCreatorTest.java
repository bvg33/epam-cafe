package com.epam.web.dao.querycreator;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class QueryCreatorTest {
    private final Creator creator=new QueryCreator();

    @Test
    public void testCreateInsertQueryShouldReturnQueryWhenParametersIsCorrect(){
        Map<String,String> fields=new HashMap<>();
        fields.put("name","name");
        fields.put("login","login");
        String actual=creator.createInsertQuery("test",fields);
        String expected="insert into test (name,login) values(?,?)";
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testCreateInsertQueryShouldReturnQueryWithoutParameters(){
        Map<String,String> fields=new HashMap<>();
        String actual=creator.createInsertQuery("test",fields);
        String expected="insert into test () values()";
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testCreateUpdateQueryShouldReturnQueryWhenParametersIsCorrect(){
        Map<String,String> fields=new HashMap<>();
        fields.put("name","name");
        fields.put("login","login");
        fields.put("id","1");
        String actual=creator.createUpdateQuery("test",fields);
        String expected="update test set name=?,login=? where id=1";
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testCreateUpdateQueryShouldReturnQueryWithoutParameters(){
        Map<String,String> fields=new HashMap<>();
        String actual=creator.createUpdateQuery("test",fields);
        String expected="update test set  where id=null";
        Assert.assertEquals(expected,actual);
    }

}
