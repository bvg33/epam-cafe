package com.epam.web.dao.extractor;

import com.epam.web.entity.Rating;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RatingFieldExtractor implements EntityFieldExtractor<Rating> {
    int test;
    @Override
    public Map<String, String> parse(Rating entity) {
        int id=entity.getId();
        int orderId=entity.getOrderId();
        int stars=entity.getStars();
        String idString=String.valueOf(id);
        String orderIdString=String.valueOf(orderId);
        String starsString=String.valueOf(stars);
        Map<String,String> result=new HashMap<>();
        result.put("id",idString);
        result.put("order_id",orderIdString);
        result.put("stars",starsString);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return true;
    }
}
