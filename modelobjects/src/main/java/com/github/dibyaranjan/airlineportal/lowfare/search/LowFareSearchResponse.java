package com.github.dibyaranjan.airlineportal.lowfare.search;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LowFareSearchResponse {
    @JsonProperty("currency")
    private String currency;

    private List<LowFareSearchResult> results;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<LowFareSearchResult> getResults() {
        return results;
    }

    public void setResults(List<LowFareSearchResult> results) {
        this.results = results;
    }

}
