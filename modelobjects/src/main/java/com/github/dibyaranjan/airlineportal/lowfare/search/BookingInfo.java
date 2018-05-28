package com.github.dibyaranjan.airlineportal.lowfare.search;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingInfo {
    @JsonProperty("travel_class")
    private String travelClass;
    
    @JsonProperty("booking_code")
    private String bookingCode;
    
    @JsonProperty("seat_remaining")
    private int seatsRemaining;

    public String getTravelClass() {
        return this.travelClass;
    }

    public void setTravelClass(String travelClass) {
        this.travelClass = travelClass;
    }

    public String getBookingCode() {
        return this.bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public int getSeatsRemaining() {
        return this.seatsRemaining;
    }

    public void setSeatsRemaining(int seatsRemaining) {
        this.seatsRemaining = seatsRemaining;
    }
}
