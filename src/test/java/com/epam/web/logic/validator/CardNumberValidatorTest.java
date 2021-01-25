package com.epam.web.logic.validator;

import org.junit.Assert;
import org.junit.Test;

public class CardNumberValidatorTest {
    private final AbstractValidator validator=new CardNumberValidator();

    @Test
    public void testCardNumberValidatorShouldReturnTrueWhenDataIsCorrect(){
        String testString="1111 1111 1111 1111";
        boolean actual=validator.isValid(testString);
        Assert.assertEquals(true,actual);
    }
    @Test
    public void testCardNumberValidatorShouldReturnFalseWhenDataIsNotCorrect(){
        String testString="1111 1111 1111";
        boolean actual=validator.isValid(testString);
        Assert.assertEquals(false,actual);
    }
}
