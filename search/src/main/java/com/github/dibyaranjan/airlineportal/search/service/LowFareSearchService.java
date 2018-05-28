package com.github.dibyaranjan.airlineportal.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.github.dibyaranjan.airlineportal.framework.rest.comsumer.RestConsumer;
import com.github.dibyaranjan.airlineportal.lowfare.search.LowFareSearchResponse;
import com.github.dibyaranjan.airlineportal.lowfare.search.LowFareSearchResult;
import com.github.dibyaranjan.airlineportal.search.configuration.RestEndPointProperties;
import com.github.dibyaranjan.airlineportal.search.consumer.LowFareSearchResultProcessor;
import com.github.dibyaranjan.airlineportal.search.vo.FlightProposal;

@Service
@Scope(value = "prototype")
public class LowFareSearchService {
    @Autowired
    private RestEndPointProperties endPointProperties;

    @Autowired
    private RestConsumer<LowFareSearchResponse> lowFareRestConsumer;

    @Autowired
    private LowFareSearchResultProcessor searchResultProcessor;

    public List<FlightProposal> getFlightProposals() {
        LowFareSearchResponse response = lowFareRestConsumer.getObject(endPointProperties.getLowFareSearchEndpoint(),
                LowFareSearchResponse.class);

        List<LowFareSearchResult> results = response.getResults();

        results.parallelStream().forEach(searchResultProcessor::processFareResult);
        return searchResultProcessor.getProposals();
    }
}
