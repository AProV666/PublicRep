package com.pro.springapp.model.modelFromMoex;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Boards {
    @JsonProperty("metadata")
    public Metadata getMetadata() {
        return this.metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    Metadata metadata;

    @JsonProperty("columns")
    public ArrayList<String> getColumns() {
        return this.columns;
    }

    public void setColumns(ArrayList<String> columns) {
        this.columns = columns;
    }

    ArrayList<String> columns;

    @JsonProperty("data")
    public ArrayList<ArrayList<Object>> getData() {
        return this.data;
    }

    public void setData(ArrayList<ArrayList<Object>> data) {
        this.data = data;
    }

    ArrayList<ArrayList<Object>> data;
}
