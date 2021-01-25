package com.epam.web.dao.extractor;

import com.epam.web.entity.Menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MenuFieldExtractor implements EntityFieldExtractor<Menu>{
    @Override
    public Map<String, String> parse(Menu entity) {
        int id =entity.getId();
        String name= entity.getName();
        String price=entity.getPrice();
        String photo=entity.getPhoto();
        String stringId=String.valueOf(id);
        int isActive=entity.getIsActive();
        String isActiveString=String.valueOf(isActive);
        Map<String,String>result=new HashMap<>();
        result.put("is_active",isActiveString);
        result.put("id",stringId);
        result.put("name",name);
        result.put("price",price);
        result.put("photo",photo);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return true;
    }
}
