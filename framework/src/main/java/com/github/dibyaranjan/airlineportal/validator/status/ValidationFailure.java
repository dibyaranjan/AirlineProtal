package com.github.dibyaranjan.airlineportal.validator.status;

import com.github.dibyaranjan.airlineportal.validator.exception.MissingMandatoryElementException;

public class ValidationFailure implements ValidationStatus {
    private ValidationFailureCause cause;
    private String errorMessages;

    public void setCause(ValidationFailureCause cause) {
        this.cause = cause;
    }

    public void setErrorMessages(String errorMessages) {
        this.errorMessages = errorMessages;
    }

    @Override
    public void process() {
        if (ValidationFailureCause.MISSING_MANDATORY_FIELDS.equals(cause)) {
            throw new MissingMandatoryElementException(errorMessages);
        }
    }

}
