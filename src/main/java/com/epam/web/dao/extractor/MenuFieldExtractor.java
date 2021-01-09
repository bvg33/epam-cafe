package com.epam.web.dao.extractor;

import com.epam.web.entity.Menu;

import java.util.HashMap;
import java.util.Map;

public class MenuFieldExtractor implements EntityFieldExtractor<Menu>{
    @Override
    public Map<String, String> parse(Menu entity) {
        int id =entity.getId();
        String name= entity.getName();
        String price=entity.getPrice();
        String description=entity.getDescription();
        String photo=entity.getPhoto();
        String stringId=String.valueOf(id);
        Map<String,String>result=new HashMap<>();
        result.put("id",stringId);
        result.put("name",name);
        result.put("description",description);
        result.put("price",price);
        result.put("photo",photo);
        return result;
    }
}
