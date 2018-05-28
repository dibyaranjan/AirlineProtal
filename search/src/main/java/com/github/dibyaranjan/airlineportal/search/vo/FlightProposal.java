package com.github.dibyaranjan.airlineportal.search.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Value object to represent a Flight proposal to the user. This could be a direct or a connecting flight.
 * 
 * @author dranjan
 */
public class FlightProposal {
    private String origin;
    private String destination;
    private String originTime;
    private String destinationTime;
    private String currency;
    private List<FlightSegment> flightSegments;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOriginTime() {
        return originTime;
    }

    public void setOriginTime(String originTime) {
        this.originTime = originTime;
    }

    public String getDestinationTime() {
        return destinationTime;
    }

    public void setDestinationTime(String destinationTime) {
        this.destinationTime = destinationTime;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<FlightSegment> getFlightSegments() {
        return flightSegments;
    }

    public void setFlightSegments(List<FlightSegment> flightSegments) {
        this.flightSegments = flightSegments;
    }

    public void addFlightSegment(FlightSegment flightSegment) {
        if (flightSegments == null) {
            this.flightSegments = new ArrayList<>();
        }

        this.flightSegments.add(flightSegment);
    }

    @Override
    public String toString() {
        return "FlightProposal [origin=" + origin + ", destination=" + destination + ", originTime=" + originTime
                + ", destinationTime=" + destinationTime + ", flightSegments=" + flightSegments + "]";
    }

}
