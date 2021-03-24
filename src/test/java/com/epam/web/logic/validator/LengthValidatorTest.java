package com.epam.web.logic.validator;

import org.junit.Assert;
import org.junit.Test;

public class LengthValidatorTest {
    private final AbstractValidator validator=new LengthValidator();

    @Test
    public void testLengthValidatorShouldReturnTrueWhenDataIsCorrect(){
        String testString="123456789";
        boolean actual=validator.isValid(testString);
        Assert.assertTrue(actual);
    }

    @Test
    public void testLengthValidatorShouldReturnFalseWhenDataIsNotCorrect(){
        String testString="123456789012345678901234567890123456788";
        boolean actual=validator.isValid(testString);
        Assert.assertFalse(actual);
    }
}
