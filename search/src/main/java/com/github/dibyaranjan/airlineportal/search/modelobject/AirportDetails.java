package com.github.dibyaranjan.airlineportal.search.modelobject;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AirportDetails {

    private Airport airport;

    @JsonProperty("Links")
    private AirportLink link;

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public AirportLink getLink() {
        return link;
    }

    public void setLink(AirportLink link) {
        this.link = link;
    }
}
