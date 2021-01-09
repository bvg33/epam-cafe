package com.epam.web.dao.converter;

import com.epam.web.dto.MenuDto;
import com.epam.web.entity.Menu;

public class MenuConverter implements Converter<MenuDto, Menu> {

    @Override
    public MenuDto convert(Menu entity) {
        String price=entity.getPrice();
        price=price.split(" ")[0];
        int priceInt=Integer.parseInt(price);
        String photo=entity.getPhoto();
        String name=entity.getName();
        int id=entity.getId();
        return new MenuDto(id,priceInt,name,photo);
    }
}
