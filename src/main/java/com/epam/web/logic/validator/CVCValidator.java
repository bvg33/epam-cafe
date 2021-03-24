package com.epam.web.logic.validator;

public class CVCValidator extends AbstractValidator {
    private static final String CVC_REGEX="\\d\\d\\d";

    @Override
    protected String getRegex() {
        return CVC_REGEX;
    }
}
