package com.epam.web.dao.extractor;

import com.epam.web.entity.Order;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class OrderFieldExtractor implements EntityFieldExtractor<Order> {
    @Override
    public Map<String, String> parse(Order entity) {
        int id=entity.getId();
        String price=entity.getPrice();
        String state=entity.getState().toString().toLowerCase();
        String time=entity.getTime();
        String type=entity.getType().toString().toLowerCase();
        int userId=entity.getUserId();
        String idString=String.valueOf(id);
        String userIdString=String.valueOf(userId);
        Map<String,String> map=new HashMap<>();
        map.put("id",idString);
        map.put("price",price);
        map.put("state",state);
        map.put("time",time);
        map.put("type",type);
        map.put("user_id",userIdString);
        return map;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return true;
    }
}
