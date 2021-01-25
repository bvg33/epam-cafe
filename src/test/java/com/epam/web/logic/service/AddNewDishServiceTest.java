package com.epam.web.logic.service;

import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.enums.NewDishResponseEnum;
import com.epam.web.logic.validator.AbstractValidator;
import com.epam.web.logic.validator.LengthValidator;
import com.epam.web.logic.validator.PriceValidator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class AddNewDishServiceTest {
    private final AddNewDishService service=new AddNewDishService(new DaoHelperFactory());

    @Test
    public void testIsValidDataShouldReturnOKWhenDataIsValid(){
        AbstractValidator priceValidator = Mockito.mock(PriceValidator.class);
        AbstractValidator lengthValidator = Mockito.mock(LengthValidator.class);
        when(priceValidator.isValid(anyString())).thenReturn(true);
        when(lengthValidator.isValid(anyString())).thenReturn(true);
        NewDishResponseEnum actual=service.isValidData("name","price",priceValidator,lengthValidator);
        Assert.assertEquals(NewDishResponseEnum.OK,actual);
    }

    @Test
    public void testIsValidDataShouldReturnWrongNameWhenNameIsNotValid(){
        AbstractValidator priceValidator = Mockito.mock(PriceValidator.class);
        AbstractValidator lengthValidator = Mockito.mock(LengthValidator.class);
        when(priceValidator.isValid(anyString())).thenReturn(true);
        when(lengthValidator.isValid(anyString())).thenReturn(false);
        NewDishResponseEnum actual=service.isValidData("name","price",priceValidator,lengthValidator);
        Assert.assertEquals(NewDishResponseEnum.WRONG_NAME,actual);
    }

    @Test
    public void testIsValidDataShouldReturnWrongPriceWhenPriceIsNotValid(){
        AbstractValidator priceValidator = Mockito.mock(PriceValidator.class);
        AbstractValidator lengthValidator = Mockito.mock(LengthValidator.class);
        when(priceValidator.isValid(anyString())).thenReturn(false);
        when(lengthValidator.isValid(anyString())).thenReturn(true);
        NewDishResponseEnum actual=service.isValidData("name","price",priceValidator,lengthValidator);
        Assert.assertEquals(NewDishResponseEnum.WRONG_PRICE,actual);
    }
}
