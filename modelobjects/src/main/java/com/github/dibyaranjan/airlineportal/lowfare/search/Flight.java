package com.github.dibyaranjan.airlineportal.lowfare.search;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Flight {
    @JsonProperty("arrives_at")
    private String arrivesAt;

    @JsonProperty("departs_at")
    private String departsAt;

    @JsonProperty("marketing_airline")
    private String marketingAirline;

    @JsonProperty("operating_airline")
    private String operatingAirline;

    @JsonProperty("flight_number")
    private String flightNumber;

    @JsonProperty("booking_info")
    private BookingInfo bookingInfo;

    private String aircraft;
    private Origin origin;
    private Destination destination;

    public String getDepartsAt() {
        return this.departsAt;
    }

    public void setDepartsAt(String departsAt) {
        this.departsAt = departsAt;
    }

    public String getArrivesAt() {
        return this.arrivesAt;
    }

    public void setArrivesAt(String arrivesAt) {
        this.arrivesAt = arrivesAt;
    }

    public Origin getOrigin() {
        return this.origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public Destination getDestination() {
        return this.destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public String getMarketingAirline() {
        return this.marketingAirline;
    }

    public void setMarketingAirline(String marketingAirline) {
        this.marketingAirline = marketingAirline;
    }

    public String getOperatingAirline() {
        return this.operatingAirline;
    }

    public void setOperatingAirline(String operatingAirline) {
        this.operatingAirline = operatingAirline;
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAircraft() {
        return this.aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public BookingInfo getBookingInfo() {
        return this.bookingInfo;
    }

    public void setBookingInfo(BookingInfo bookingInfo) {
        this.bookingInfo = bookingInfo;
    }
}
