package com.epam.web.logic.validator;

import org.junit.Assert;
import org.junit.Test;

public class PriceValidatorTest {
    private final AbstractValidator validator=new PriceValidator();

    @Test
    public void testPriceValidatorShouldReturnTrueWhenDataIsCorrect(){
        String testString="2.5 BYN";
        boolean actual=validator.isValid(testString);
        Assert.assertTrue(actual);
    }

    @Test
    public void testPriceValidatorShouldReturnFalseWhenDataIsNotCorrect(){
        String testString="2.5 dsffBYN";
        boolean actual=validator.isValid(testString);
        Assert.assertFalse(actual);
    }
}
