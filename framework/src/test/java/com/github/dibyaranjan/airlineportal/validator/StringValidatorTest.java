package com.github.dibyaranjan.airlineportal.validator;

import org.junit.Before;
import org.junit.Test;

import com.github.dibyaranjan.airlineportal.validator.exception.ValidationException;
import com.github.dibyaranjan.airlineportal.validator.status.ValidationStatus;

public class StringValidatorTest {
    private StringValidator stringValidator;

    @Before
    public void setUp() {
        stringValidator = new StringValidator();
    }

    @Test(expected = ValidationException.class)
    public void testValidatorWithBlank() {
        ValidationStatus status = stringValidator.validate("     ");
        status.process();
    }
    
    @Test
    public void testValidatorWithValidString() {
        ValidationStatus status = stringValidator.validate("asdf");
        status.process();
    }
}
