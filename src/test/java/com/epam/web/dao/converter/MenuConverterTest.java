package com.epam.web.dao.converter;

import com.epam.web.dto.MenuDto;
import com.epam.web.entity.Menu;
import org.junit.Assert;
import org.junit.Test;

public class MenuConverterTest {
    private final Converter<MenuDto,Menu> converter=new MenuConverter();

    @Test
    public void testConvertShouldReturnMenuDtoWhenMenuIsCorrect(){
        Menu menu=new Menu(1,"name","5.5","photo",0);
        MenuDto actual=converter.convert(menu);
        MenuDto expected=new MenuDto(1,5.5,"name","photo");
        Assert.assertEquals(expected,actual);
    }

    @Test(expected = Exception.class)
    public void testConvertShouldThrowExceptionWhenMenuIsNotCorrect(){
        Menu menu=new Menu(1,"name","5.5gg","photo",0);
        MenuDto actual=converter.convert(menu);
    }
}
