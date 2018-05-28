package com.github.dibyaranjan.airlineportal.lowfare.search;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Fare {
    @JsonProperty("total_price")
    private String totalPrice;

    @JsonProperty("price_per_adult")
    private PricePerAdult pricePerAdult;

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public PricePerAdult getPricePerAdult() {
        return pricePerAdult;
    }

    public void setPricePerAdult(PricePerAdult pricePerAdult) {
        this.pricePerAdult = pricePerAdult;
    }

}
