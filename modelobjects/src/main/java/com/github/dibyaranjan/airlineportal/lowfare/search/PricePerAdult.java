package com.github.dibyaranjan.airlineportal.lowfare.search;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PricePerAdult {
    @JsonProperty("total_fare")
    private String totalFare;
    private String tax;

    public String getTotalFare() {
        return this.totalFare;
    }

    public void setTotalFare(String totalFare) {
        this.totalFare = totalFare;
    }

    public String getTax() {
        return this.tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }
}
