package com.github.dibyaranjan.airlineportal.modelobjects.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AirportJson {
    @JsonProperty("Airports")
    private List<Airport> airports;

    public List<Airport> getAirports() {
        return airports;
    }
}
