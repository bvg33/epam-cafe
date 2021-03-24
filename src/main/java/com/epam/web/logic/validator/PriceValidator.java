package com.epam.web.logic.validator;

public class PriceValidator extends AbstractValidator {
    private static final String NAME_REGEX="^\\d{1,4}(\\.\\d{1,4})*\\sBYN$";

    @Override
    protected String getRegex() {
        return NAME_REGEX;
    }
}
