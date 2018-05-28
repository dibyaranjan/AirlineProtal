package com.github.dibyaranjan.airlineportal.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.dibyaranjan.airlineportal.request.vo.FlightProposalRequest;
import com.github.dibyaranjan.airlineportal.validator.status.ValidationFailureCause;
import com.github.dibyaranjan.airlineportal.validator.status.ValidationStatus;

@Repository
public class FlightProposalRequestValidator implements Validator<FlightProposalRequest> {
    @Autowired
    private Validator<String> validator;

    public void setValidator(Validator<String> validator) {
        this.validator = validator;
    }

    @Override
    public ValidationStatus validate(FlightProposalRequest request) {
        if (isValid(request)) {
            return ValidationStatus.success();
        } else {
            return ValidationStatus.fail(ValidationFailureCause.MISSING_MANDATORY_FIELDS, "Request is null");
        }
    }

    /**
     * Returns true only if
     * 
     * @see com.github.dibyaranjan.airlineportal.validator.Validator#isValid(java.lang.Object)
     */
    @Override
    public boolean isValid(FlightProposalRequest request) {
        if (request == null) {
            return false;
        }

        return validator.isValid(request.getArrivalAirport()) && validator.isValid(request.getDepartureAirport())
                && validator.isValid(request.getDepartureDate()) && validator.isValid(request.getReturnDate());
    }
}
