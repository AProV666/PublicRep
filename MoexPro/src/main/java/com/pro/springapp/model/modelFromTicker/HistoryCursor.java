package com.pro.springapp.model.modelFromTicker;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class HistoryCursor {
    @JsonProperty("metadata")
    public Metadata getMetadata() {
        return this.metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    Metadata metadata;

    @JsonProperty("columns")
    public ArrayList<Object> getColumns() {
        return this.columns;
    }

    public void setColumns(ArrayList<Object> columns) {
        this.columns = columns;
    }

    ArrayList<Object> columns;

    @JsonProperty("data")
    public ArrayList<ArrayList<Integer>> getData() {
        return this.data;
    }

    public void setData(ArrayList<ArrayList<Integer>> data) {
        this.data = data;
    }

    ArrayList<ArrayList<Integer>> data;
}
