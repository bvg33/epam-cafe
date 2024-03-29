package com.epam.web.dao.converter;

import com.epam.web.dto.MenuDto;
import com.epam.web.entity.Menu;

public class MenuConverter implements Converter<MenuDto, Menu> {
    private static final String REGEX=" ";
    @Override
    public MenuDto convert(Menu entity) {
        String price=entity.getPrice();
        price=price.split(REGEX)[0];
        double priceDouble=Double.parseDouble(price);
        String photo=entity.getPhoto();
        String name=entity.getName();
        int id=entity.getId();
        return new MenuDto(id,priceDouble,name,photo);
    }
}
