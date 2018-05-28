package com.github.dibyaranjan.airlineportal.search.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.dibyaranjan.airlineportal.request.vo.FlightProposalRequest;
import com.github.dibyaranjan.airlineportal.search.controller.config.LowFareSearchServiceITConfiguration;
import com.github.dibyaranjan.airlineportal.validator.exception.ValidationException;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { LowFareSearchServiceITConfiguration.class })
public class FlightProposalControllerIT {
    @Autowired
    private FlightProposalController controller;

    @Test(expected = ValidationException.class)
    public void testControllerWithNullRequest() {
        controller.getAvailability(null);
    }
    
    @Test(expected = ValidationException.class)
    public void testControllerWithMissingElementInRequest() {
        FlightProposalRequest request = new FlightProposalRequest();
        
        controller.getAvailability(request);
    }
    
    @Test
    public void testControllerWithValidRequest() {
        FlightProposalRequest request = new FlightProposalRequest();
        request.setArrivalAirport("DXB");
        request.setDepartureAirport("LHR");
        request.setDepartureDate("26-08-1991");
        request.setReturnDate("26-09-1991");
        
        controller.getAvailability(request);
    }
}
