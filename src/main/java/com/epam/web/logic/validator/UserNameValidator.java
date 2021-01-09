package com.epam.web.logic.validator;

public class UserNameValidator extends AbstractValidator {
    private static final String NAME_REGEX="^[A-ZА-Я][a-zа-я]{3,20}$";

    @Override
    protected String getRegex() {
        return NAME_REGEX;
    }
}
