package com.epam.web.logic.service;

import com.epam.web.connection.ConnectionPool;
import com.epam.web.dao.converter.MenuConverter;
import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.menudao.MenuDaoImpl;
import com.epam.web.dto.MenuDto;
import com.epam.web.entity.Menu;
import com.epam.web.enums.NewDishResponseEnum;
import com.epam.web.exceptions.ConnectionException;
import com.epam.web.exceptions.DaoException;
import com.epam.web.exceptions.ServiceException;
import com.epam.web.logic.validator.AbstractValidator;
import com.epam.web.logic.validator.LengthValidator;
import com.epam.web.logic.validator.PriceValidator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.when;

public class AddToBucketServiceTest {

    @Test
    public void testCreateMenuDtoShouldReturnMenuDtoWhenDataIsCorrect() throws ServiceException, DaoException, ConnectionException {
        DaoHelperFactory daoHelperFactory = Mockito.mock(DaoHelperFactory.class);
        DaoHelper daoHelper=Mockito.mock(DaoHelper.class);
        MenuDaoImpl dao=Mockito.mock(MenuDaoImpl.class);
        Menu menu=new Menu(1,"name","5.5","photo",0);
        Optional<Menu> menuOptional=Optional.of(menu);
        when(dao.getById(anyInt())).thenReturn(menuOptional);
        MenuConverter converter=Mockito.mock(MenuConverter.class);
        MenuDto dto=new MenuDto(1,5.5,"name","photo");
        mock(daoHelper,daoHelperFactory,converter,dao,dto);
        AddToBucketService service=new AddToBucketService(daoHelperFactory);
        MenuDto actual=service.createMenuDto(1,converter);
        Assert.assertEquals(dto,actual);
    }

    @Test(expected = DaoException.class)
    public void testCreateMenuDtoShouldThrowExceptionWhenDataIsNotCorrect() throws ServiceException, DaoException, ConnectionException {
        DaoHelperFactory daoHelperFactory = Mockito.mock(DaoHelperFactory.class);
        DaoHelper daoHelper=Mockito.mock(DaoHelper.class);
        MenuDaoImpl dao=Mockito.mock(MenuDaoImpl.class);
        MenuConverter converter=Mockito.mock(MenuConverter.class);
        MenuDto dto=new MenuDto(1,5.5,"name","photo");
        when(dao.getById(anyInt())).thenThrow(DaoException.class);
        mock(daoHelper,daoHelperFactory,converter,dao,dto);
        AddToBucketService service=new AddToBucketService(daoHelperFactory);
        MenuDto actual=service.createMenuDto(1,converter);
    }

    @Test
    public void testUpdateBucketShouldReturnListWhenDataIsCorrect(){
        MenuDto dto=new MenuDto(1,5.5,"name","photo");
        ArrayList<MenuDto> actual=new ArrayList<>();
        actual.add(dto);
        AddToBucketService service=new AddToBucketService(new DaoHelperFactory());
        service.updateBucket(dto,actual);
        ArrayList<MenuDto> expected=new ArrayList<>();
        dto.incrementCount();
        expected.add(dto);
        Assert.assertEquals(expected,actual);
    }

    private void mock(DaoHelper daoHelper, DaoHelperFactory daoHelperFactory, MenuConverter converter, MenuDaoImpl dao, MenuDto dto) throws ConnectionException {
        when(daoHelper.createMenuDao()).thenReturn(dao);
        when(daoHelperFactory.createDaoHelper()).thenReturn(daoHelper);
        when(converter.convert(anyObject())).thenReturn(dto);
    }
}
