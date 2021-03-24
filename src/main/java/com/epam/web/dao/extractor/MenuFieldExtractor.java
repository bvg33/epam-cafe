package com.epam.web.dao.extractor;

import com.epam.web.entity.Menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MenuFieldExtractor implements EntityFieldExtractor<Menu>{
    private static final String IS_ACTIVE="is_active";
    private static final String ID="id";
    private static final String NAME="name";
    private static final String PRICE="price";
    private static final String PHOTO="photo";

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
        result.put(IS_ACTIVE,isActiveString);
        result.put(ID,stringId);
        result.put(NAME,name);
        result.put(PRICE,price);
        result.put(PHOTO,photo);
        return result;
    }

}
