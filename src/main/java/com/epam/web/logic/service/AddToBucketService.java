package com.epam.web.logic.service;

import com.epam.web.dao.Dao;
import com.epam.web.dao.converter.Converter;
import com.epam.web.dao.converter.MenuConverter;
import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.menudao.MenuDaoImpl;
import com.epam.web.dto.MenuDto;
import com.epam.web.entity.Menu;
import com.epam.web.exceptions.ConnectionException;
import com.epam.web.exceptions.DaoException;
import com.epam.web.exceptions.ServiceException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class AddToBucketService {
    private final DaoHelperFactory daoHelperFactory;

    public AddToBucketService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public MenuDto createMenuDto(int id, Converter converter) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.createDaoHelper()) {
            Dao dao = daoHelper.createMenuDao();
            Optional<Menu> menuOptional = null;
            menuOptional = dao.getById(id);
            Menu menu = menuOptional.get();
            return (MenuDto) converter.convert(menu);
        } catch (DaoException | ConnectionException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public ArrayList<MenuDto> createBucket(MenuDto menuDto) {
        ArrayList<MenuDto> newBucket = new ArrayList<>();
        newBucket.add(menuDto);
        return newBucket;
    }

    public void updateBucket(MenuDto menuDto, ArrayList<MenuDto> bucket) {
        int index = bucket.indexOf(menuDto);
        menuDto = bucket.get(index);
        menuDto.incrementCount();
    }
}
