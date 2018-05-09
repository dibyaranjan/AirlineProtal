package com.github.dibyaranjan.airlineportal.modelobjects.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Airport {
    @JsonProperty("code")
    private String iataCode;
    private String name;
    private String countryName;

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
