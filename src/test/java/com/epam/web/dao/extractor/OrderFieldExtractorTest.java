package com.epam.web.dao.extractor;

import com.epam.web.dao.orderdtodao.OrderDtoDao;
import com.epam.web.entity.Menu;
import com.epam.web.entity.Order;
import com.epam.web.enums.OrderStateEnum;
import com.epam.web.enums.OrderTypeEnum;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class OrderFieldExtractorTest {
    private final EntityFieldExtractor<Order>extractor=new OrderFieldExtractor();

    @Test
    public void testOrderFieldExtractorShouldExtractWhenBucketIsCorrectAndMapsShouldEquals(){
        Order order=new Order(1,"5", OrderTypeEnum.CASH, OrderStateEnum.ACCEPT,"12:44",1);
        Map<String,String> actual=extractor.parse(order);
        Map<String,String> expected=createExpectedMap();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testOrderFieldExtractorShouldExtractWhenBucketIsCorrectAndMapsShouldNotEquals(){
        Order order=new Order(1,"5", OrderTypeEnum.CASH, OrderStateEnum.ACCEPT,"12:44",2);
        Map<String,String> actual=extractor.parse(order);
        Map<String,String> expected=createExpectedMap();
        Assert.assertNotEquals(expected,actual);
    }
    private Map<String,String> createExpectedMap(){
        Map<String,String>expected=new HashMap<>();
        expected.put("id","1");
        expected.put("price","5");
        expected.put("state","accept");
        expected.put("time","12:44");
        expected.put("type","cash");
        expected.put("user_id","1");
        return expected;
    }
}
