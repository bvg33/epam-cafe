package com.epam.web.logic.validator;

import org.junit.Assert;
import org.junit.Test;

public class LoginValidatorTest {
    private final AbstractValidator validator=new LoginValidator();

    @Test
    public void testLoginValidatorShouldReturnTrueWhenDataIsCorrect(){
        String testString="newLogin";
        boolean actual=validator.isValid(testString);
        Assert.assertEquals(true,actual);
    }

    @Test
    public void testLoginValidatorShouldReturnFalseWhenDataIsNotCorrect(){
        String testString="123";
        boolean actual=validator.isValid(testString);
        Assert.assertEquals(false,actual);
    }
}
