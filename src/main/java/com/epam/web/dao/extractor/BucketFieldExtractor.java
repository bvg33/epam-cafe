package com.epam.web.dao.extractor;

import com.epam.web.entity.Bucket;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BucketFieldExtractor implements EntityFieldExtractor<Bucket> {
    private static final String DISH_ID="dish_id";
    private static final String ID="id";
    private static final String ORDER_ID="order_id";
    private static final String COUNT="count";

    @Override
    public Map<String, String> parse(Bucket entity) {
        int dishId=entity.getDishId();
        int id=entity.getId();
        int orderNumber=entity.getOrderNumber();
        int count=entity.getCount();
        String stringDishId=String.valueOf(dishId);
        String stringId=String.valueOf(id);
        String stringOrderNumber=String.valueOf(orderNumber);
        String stringCount=String.valueOf(count);
        Map<String,String> map=new HashMap<>();
        map.put(DISH_ID,stringDishId);
        map.put(ID,stringId);
        map.put(ORDER_ID,stringOrderNumber);
        map.put(COUNT,stringCount);
        return map;
    }

}
