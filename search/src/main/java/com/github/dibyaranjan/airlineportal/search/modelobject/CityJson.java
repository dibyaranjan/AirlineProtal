package com.github.dibyaranjan.airlineportal.search.modelobject;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CityJson {
    private String code;
    private String name;
    @JsonProperty("Links")
    private List<AirportLink> airportLinks;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AirportLink> getAirportLinks() {
        return airportLinks;
    }

    public void setAirportLinks(List<AirportLink> airportLinks) {
        this.airportLinks = airportLinks;
    }

    @Override
    public String toString() {
        return "CityJson{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", airportLinks=" + airportLinks +
                '}';
    }
}
