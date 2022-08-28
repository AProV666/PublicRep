package com.pro.springapp.model.modelFromTicker;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MarketPrice2 {
    @JsonProperty("type")
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    String type;
}
