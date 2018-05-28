package com.github.dibyaranjan.airlineportal.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.dibyaranjan.airlineportal.request.vo.FlightProposalRequest;
import com.github.dibyaranjan.airlineportal.search.service.LowFareSearchService;
import com.github.dibyaranjan.airlineportal.search.vo.FlightProposal;
import com.github.dibyaranjan.airlineportal.validator.FlightProposalRequestValidator;
import com.github.dibyaranjan.airlineportal.validator.status.ValidationStatus;

/**
 *
 * @author Dibya Ranjan
 */
@RestController
@RequestMapping("/flights")
public class FlightProposalController {
    @Autowired
    private LowFareSearchService fareSerachService;
    
    @Autowired
    private FlightProposalRequestValidator validator;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<FlightProposal> getAvailability(FlightProposalRequest request) {
        ValidationStatus status = validator.validate(request);
        status.process();

        return fareSerachService.getFlightProposals();
    }
}
