package com.pro.springapp.model.modelFromMoex;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Metadata {
    @JsonProperty("name")
    public Name getName() {
        return this.name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    Name name;

    @JsonProperty("title")
    public Title getTitle() {
        return this.title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    Title title;

    @JsonProperty("value")
    public Value getValue() {
        return this.value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    Value value;

    @JsonProperty("type")
    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    Type type;

    @JsonProperty("sort_order")
    public SortOrder getSort_order() {
        return this.sort_order;
    }

    public void setSort_order(SortOrder sort_order) {
        this.sort_order = sort_order;
    }

    SortOrder sort_order;

    @JsonProperty("is_hidden")
    public IsHidden getIs_hidden() {
        return this.is_hidden;
    }

    public void setIs_hidden(IsHidden is_hidden) {
        this.is_hidden = is_hidden;
    }

    IsHidden is_hidden;

    @JsonProperty("precision")
    public Precision getPrecision() {
        return this.precision;
    }

    public void setPrecision(Precision precision) {
        this.precision = precision;
    }

    Precision precision;

    @JsonProperty("secid")
    public Secid getSecid() {
        return this.secid;
    }

    public void setSecid(Secid secid) {
        this.secid = secid;
    }

    Secid secid;

    @JsonProperty("boardid")
    public Boardid getBoardid() {
        return this.boardid;
    }

    public void setBoardid(Boardid boardid) {
        this.boardid = boardid;
    }

    Boardid boardid;

    @JsonProperty("board_group_id")
    public BoardGroupId getBoard_group_id() {
        return this.board_group_id;
    }

    public void setBoard_group_id(BoardGroupId board_group_id) {
        this.board_group_id = board_group_id;
    }

    BoardGroupId board_group_id;

    @JsonProperty("market_id")
    public MarketId getMarket_id() {
        return this.market_id;
    }

    public void setMarket_id(MarketId market_id) {
        this.market_id = market_id;
    }

    MarketId market_id;

    @JsonProperty("market")
    public Market getMarket() {
        return this.market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    Market market;

    @JsonProperty("engine_id")
    public EngineId getEngine_id() {
        return this.engine_id;
    }

    public void setEngine_id(EngineId engine_id) {
        this.engine_id = engine_id;
    }

    EngineId engine_id;

    @JsonProperty("engine")
    public Engine getEngine() {
        return this.engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    Engine engine;

    @JsonProperty("is_traded")
    public IsTraded getIs_traded() {
        return this.is_traded;
    }

    public void setIs_traded(IsTraded is_traded) {
        this.is_traded = is_traded;
    }

    IsTraded is_traded;

    @JsonProperty("decimals")
    public Decimals getDecimals() {
        return this.decimals;
    }

    public void setDecimals(Decimals decimals) {
        this.decimals = decimals;
    }

    Decimals decimals;

    @JsonProperty("history_from")
    public HistoryFrom getHistory_from() {
        return this.history_from;
    }

    public void setHistory_from(HistoryFrom history_from) {
        this.history_from = history_from;
    }

    HistoryFrom history_from;

    @JsonProperty("history_till")
    public HistoryTill getHistory_till() {
        return this.history_till;
    }

    public void setHistory_till(HistoryTill history_till) {
        this.history_till = history_till;
    }

    HistoryTill history_till;

    @JsonProperty("listed_from")
    public ListedFrom getListed_from() {
        return this.listed_from;
    }

    public void setListed_from(ListedFrom listed_from) {
        this.listed_from = listed_from;
    }

    ListedFrom listed_from;

    @JsonProperty("listed_till")
    public ListedTill getListed_till() {
        return this.listed_till;
    }

    public void setListed_till(ListedTill listed_till) {
        this.listed_till = listed_till;
    }

    ListedTill listed_till;

    @JsonProperty("is_primary")
    public IsPrimary getIs_primary() {
        return this.is_primary;
    }

    public void setIs_primary(IsPrimary is_primary) {
        this.is_primary = is_primary;
    }

    IsPrimary is_primary;

    @JsonProperty("currencyid")
    public Currencyid getCurrencyid() {
        return this.currencyid;
    }

    public void setCurrencyid(Currencyid currencyid) {
        this.currencyid = currencyid;
    }

    Currencyid currencyid;
}
