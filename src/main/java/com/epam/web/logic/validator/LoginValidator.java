package com.epam.web.logic.validator;

public class LoginValidator extends AbstractValidator {
    private static final String LOGIN_REGEX="^[a-zA-ZА-Яа-я]{3,20}$";

    @Override
    protected String getRegex() {
        return LOGIN_REGEX;
    }
}
