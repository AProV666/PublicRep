package com.pro.springapp.model.modelFromMoex;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MarketId {
    @JsonProperty("type")
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    String type;
}
