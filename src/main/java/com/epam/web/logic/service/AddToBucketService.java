package com.epam.web.logic.service;

import com.epam.web.dao.converter.Converter;
import com.epam.web.dao.converter.MenuConverter;
import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.menudao.MenuDaoImpl;
import com.epam.web.dto.MenuDto;
import com.epam.web.entity.Menu;
import com.epam.web.exceptions.DaoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddToBucketService {
    private final DaoHelperFactory daoHelperFactory;

    public AddToBucketService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public MenuDto createMenuDto(int id) throws DaoException {
        try (DaoHelper daoHelper=daoHelperFactory.createDaoHelper()) {
            MenuDaoImpl dao=daoHelper.createMenuDao();
            Optional<Menu> menuOptional=dao.getById(id);
            Menu menu=menuOptional.get();
            Converter converter=new MenuConverter();
            return (MenuDto) converter.convert(menu);
        }
    }
    public ArrayList<MenuDto> createBucket(MenuDto menuDto){
        ArrayList<MenuDto> newBucket=new ArrayList<>();
        newBucket.add(menuDto);
        return newBucket;
    }
    public void updateBucket(MenuDto menuDto,ArrayList<MenuDto> bucket){
        int index=bucket.indexOf(menuDto);
        menuDto=bucket.get(index);
        menuDto.incrementCount();
    }
}
