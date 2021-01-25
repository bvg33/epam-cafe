package com.epam.web.dao.extractor;

import com.epam.web.entity.Bucket;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BucketFieldExtractor implements EntityFieldExtractor<Bucket> {
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
        map.put("dish_id",stringDishId);
        map.put("id",stringId);
        map.put("order_id",stringOrderNumber);
        map.put("count",stringCount);
        return map;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return true;
    }
}
