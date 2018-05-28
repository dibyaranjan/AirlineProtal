package com.github.dibyaranjan.airlineportal.search.consumer;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.github.dibyaranjan.airlineportal.lowfare.search.LowFareSearchResult;
import com.github.dibyaranjan.airlineportal.search.vo.FlightProposal;
import com.github.dibyaranjan.infra.converter.Converter;

/**
 * 
 * 
 * @author dranjan
 */
@Repository
@Scope(value = "prototype")
public class LowFareSearchResultProcessor {
    @Autowired(required = true)
    private Converter converter;

    private List<FlightProposal> proposals = new CopyOnWriteArrayList<>();

    public List<FlightProposal> getProposals() {
        return proposals;
    }

    public void processFareResult(LowFareSearchResult fareSearchResult) {
        FlightProposal flightProposal = converter.convert(new FlightProposal(), fareSearchResult);
        proposals.add(flightProposal);
    }
}
