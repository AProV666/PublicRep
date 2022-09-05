package com.pro.springapp.model.modelFromMoex;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Value {
    @JsonProperty("type")
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    String type;

    @JsonProperty("bytes")
    public int getBytes() {
        return this.bytes;
    }

    public void setBytes(int bytes) {
        this.bytes = bytes;
    }

    int bytes;

    @JsonProperty("max_size")
    public int getMax_size() {
        return this.max_size;
    }

    public void setMax_size(int max_size) {
        this.max_size = max_size;
    }

    int max_size;
}
