package com.pro.springapp.model.modelFromMoex;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Root {
    @JsonProperty("description")
    public Description getDescription() {
        return this.description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    Description description;

    @JsonProperty("boards")
    public Boards getBoards() {
        return this.boards;
    }

    public void setBoards(Boards boards) {
        this.boards = boards;
    }

    Boards boards;
}
