package com.epam.web.logic.validator;

import org.junit.Assert;
import org.junit.Test;

public class CVCValidatorTest {
    private final AbstractValidator validator=new CVCValidator();

    @Test
    public void testCVCValidatorShouldReturnTrueWhenDataIsCorrect(){
        String testString="233";
        boolean actual=validator.isValid(testString);
        Assert.assertTrue(actual);
    }

    @Test
    public void testCVCValidatorShouldReturnFalseWhenDataIsNotCorrect(){
        String testString="23";
        boolean actual=validator.isValid(testString);
        Assert.assertFalse(actual);
    }
}
