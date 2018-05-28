package com.github.dibyaranjan.airlineportal.validator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.github.dibyaranjan.airlineportal.request.vo.FlightProposalRequest;
import com.github.dibyaranjan.airlineportal.validator.exception.MissingMandatoryElementException;
import com.github.dibyaranjan.airlineportal.validator.exception.ValidationException;
import com.github.dibyaranjan.airlineportal.validator.status.ValidationStatus;

public class FlightProposalRequestValidatorTest {
    private FlightProposalRequestValidator validator;
    private FlightProposalRequest flightProposalRequest;

    @Before
    public void setUp() {
        validator = new FlightProposalRequestValidator();
        validator.setValidator(new StringValidator());
        flightProposalRequest = new FlightProposalRequest();
    }

    @Test(expected = MissingMandatoryElementException.class)
    public void testValidate_withNullData() {
        ValidationStatus validationStatus = validator.validate(null);
        validationStatus.process();

        Assert.fail("Validator should have failed with a RTE");
    }

    @Test(expected = ValidationException.class)
    public void testValidate_withAllFieldsNotSet() {
        ValidationStatus validationStatus = validator.validate(flightProposalRequest);
        validationStatus.process();

        Assert.fail("Validator should have failed with a RTE");
    }
    
    @Test(expected = ValidationException.class)
    public void testValidate_withDepartDate() {
        flightProposalRequest.setDepartureDate("26-05-2018");
        ValidationStatus validationStatus = validator.validate(flightProposalRequest);
        validationStatus.process();

        Assert.fail("Validator should have failed with a RTE");
    }
    
    @Test
    public void testValidate_withValidRequest() {
        flightProposalRequest.setArrivalAirport("LHR");
        flightProposalRequest.setDepartureAirport("DXB");
        flightProposalRequest.setDepartureDate("26-05-2018");
        flightProposalRequest.setReturnDate("26-06-2018");
        ValidationStatus validationStatus = validator.validate(flightProposalRequest);
        validationStatus.process();
    }


}
