package com.github.dibyaranjan.airlineportal.validator.status;


public interface ValidationStatus {
    default void process() {
        
    }
    
    public static ValidationStatus fail(ValidationFailureCause cause, String messages) {
        ValidationFailure validationFailure = new ValidationFailure();
        validationFailure.setCause(cause);
        validationFailure.setErrorMessages(messages);
        return validationFailure;
    }
    
    public static ValidationStatus success() {
        return new ValidationSuccess();
    }
}
