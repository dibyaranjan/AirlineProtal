package com.github.dibyaranjan.airlineportal.search.modelobject;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Cities {
    @JsonProperty("Cities")
    private List<CityJson> cities;

    public List<CityJson> getCities() {
        return cities;
    }

    public void setCities(List<CityJson> cities) {
        this.cities = cities;
    }
}
