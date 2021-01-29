package com.epam.web.dao.extractor;

import com.epam.web.entity.Rating;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RatingFieldExtractor implements EntityFieldExtractor<Rating> {
    private static final String ID="id";
    private static final String ORDER_ID="order_id";
    private static final String STARS="stars";

    @Override
    public Map<String, String> parse(Rating entity) {
        int id=entity.getId();
        int orderId=entity.getOrderId();
        int stars=entity.getStars();
        String idString=String.valueOf(id);
        String orderIdString=String.valueOf(orderId);
        String starsString=String.valueOf(stars);
        Map<String,String> result=new HashMap<>();
        result.put(ID,idString);
        result.put(ORDER_ID,orderIdString);
        result.put(STARS,starsString);
        return result;
    }

}
