package com.epam.web.logic.validator;

import org.junit.Assert;
import org.junit.Test;

public class UserNameValidatorTest {
    private final AbstractValidator validator=new UserNameValidator();

    @Test
    public void testUserNameValidatorShouldReturnTrueWhenDataIsCorrect(){
        String testString="Dima";
        boolean actual=validator.isValid(testString);
        Assert.assertTrue(actual);
    }
    @Test
    public void testUserNameValidatorShouldReturnFalseWhenDataIsNotCorrect(){
        String testString="dima";
        boolean actual=validator.isValid(testString);
        Assert.assertFalse(actual);
    }
}
