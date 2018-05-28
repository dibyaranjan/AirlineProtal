package com.github.dibyaranjan.airlineportal.validator;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.github.dibyaranjan.airlineportal.validator.status.ValidationFailureCause;
import com.github.dibyaranjan.airlineportal.validator.status.ValidationStatus;

/**
 * Validates a String class for null, empty and only space values.
 * 
 * @author dranjan
 */
@Repository
public class StringValidator implements Validator<String> {

    @Override
    public ValidationStatus validate(String request) {
        if (isValid(request)) {
            return ValidationStatus.success();
        }

        return ValidationStatus.fail(ValidationFailureCause.MISSING_MANDATORY_FIELDS, "Missing mandatory parameter");
    }

    /**
     * Returns true if the string is not null and not empty and is not a string with only spaces.
     * 
     * @see com.github.dibyaranjan.airlineportal.validator.Validator#isValid(java.lang.Object)
     */
    @Override
    public boolean isValid(String request) {
        return StringUtils.isNotBlank(request);
    }
}
