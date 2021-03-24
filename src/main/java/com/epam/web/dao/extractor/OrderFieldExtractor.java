package com.epam.web.dao.extractor;

import com.epam.web.entity.Order;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class OrderFieldExtractor implements EntityFieldExtractor<Order> {
    private static final String ID="id";
    private static final String PRICE="price";
    private static final String STATE="state";
    private static final String TIME="time";
    private static final String TYPE="type";
    private static final String USER_ID="user_id";

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
        map.put(ID,idString);
        map.put(PRICE,price);
        map.put(STATE,state);
        map.put(TIME,time);
        map.put(TYPE,type);
        map.put(USER_ID,userIdString);
        return map;
    }

}
