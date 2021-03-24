package com.epam.web.logic.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractValidator {
    /**
     * Method to get regular expression for validation
     * @return regular expression
     */
    protected abstract String getRegex();
    public boolean isValid(String expression){
        Pattern pattern = Pattern.compile(getRegex());
        Matcher matcher = pattern.matcher(expression);
        return matcher.find();
    }
}
