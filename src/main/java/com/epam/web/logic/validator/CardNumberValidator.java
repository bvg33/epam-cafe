package com.epam.web.logic.validator;

public class CardNumberValidator extends AbstractValidator {
    private static final String CARD_NUMBER_REGEX="^(\\d{4}[\\s]){3}\\d{4}$";
    @Override
    protected String getRegex() {
        return CARD_NUMBER_REGEX;
    }
}
