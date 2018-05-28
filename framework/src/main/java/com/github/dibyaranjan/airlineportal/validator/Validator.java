package com.github.dibyaranjan.airlineportal.validator;

import com.github.dibyaranjan.airlineportal.validator.status.ValidationStatus;

/**
 * Generic contract for validation.
 * 
 * @author Dibya Ranjan
 *
 * @param <T>
 */
public interface Validator<T> {
    /**
     * Validate an object and return the validation result as a Status.
     * 
     * @param request
     *            Data to be validated
     * @return can be ValidationFailure or ValidationSuccess class instance
     */
    ValidationStatus validate(T request);

    boolean isValid(T request);
}
