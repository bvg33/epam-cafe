package com.epam.web.logic.validator;

public class LengthValidator extends AbstractValidator {
    private static final String DESCRIPTION_REGEX="^.{1,30}$";

    @Override
    protected String getRegex() {
        return DESCRIPTION_REGEX;
    }
}
