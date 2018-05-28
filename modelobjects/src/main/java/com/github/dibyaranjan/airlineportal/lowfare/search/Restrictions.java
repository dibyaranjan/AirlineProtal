package com.github.dibyaranjan.airlineportal.lowfare.search;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Restrictions {
    private boolean refundable;
    @JsonProperty("change_penalties")
    private boolean changePenalties;

    public boolean getRefundable() {
        return this.refundable;
    }

    public void setRefundable(boolean refundable) {
        this.refundable = refundable;
    }


    public boolean getChangePenalties() {
        return this.changePenalties;
    }

    public void setChangePenalties(boolean change_penalties) {
        this.changePenalties = change_penalties;
    }
}
