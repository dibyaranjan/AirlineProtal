package com.github.dibyaranjan.airlineportal.validator.exception;

public class MissingMandatoryElementException extends ValidationException {
    private static final long serialVersionUID = 1L;

    public MissingMandatoryElementException(String message) {
        super(message);
    }
}
