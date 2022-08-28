package com.pro.springapp.model.modelFromTicker;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Metadata {
    @JsonProperty("BOARDID")
    public BoardId getBoardId() {
        return this.boardId;
    }

    public void setBoardId(BoardId boardId) {
        this.boardId = boardId;
    }

    BoardId boardId;

    @JsonProperty("TRADEDATE")
    public TradeDate getTradeDate() {
        return this.tradeDate;
    }

    public void setTradeDate(TradeDate tradeDate) {
        this.tradeDate = tradeDate;
    }

    TradeDate tradeDate;

    @JsonProperty("SHORTNAME")
    public ShortName getShortName() {
        return this.shortName;
    }

    public void setShortName(ShortName shortName) {
        this.shortName = shortName;
    }

    ShortName shortName;

    @JsonProperty("SECID")
    public Secid getSecid() {
        return this.secid;
    }

    public void setSecid(Secid secid) {
        this.secid = secid;
    }

    Secid secid;

    @JsonProperty("NUMTRADES")
    public NumTrades getNumTrades() {
        return this.numTrades;
    }

    public void setNumTrades(NumTrades numTrades) {
        this.numTrades = numTrades;
    }

    NumTrades numTrades;

    @JsonProperty("VALUE")
    public Value getValue() {
        return this.value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    Value value;

    @JsonProperty("OPEN")
    public Open getOpen() {
        return this.open;
    }

    public void setOpen(Open open) {
        this.open = open;
    }

    Open open;

    @JsonProperty("LOW")
    public Low getLow() {
        return this.low;
    }

    public void setLow(Low low) {
        this.low = low;
    }

    Low low;

    @JsonProperty("HIGH")
    public High getHigh() {
        return this.high;
    }

    public void setHigh(High high) {
        this.high = high;
    }

    High high;

    @JsonProperty("LEGALCLOSEPRICE")
    public LegalClosePrice getLegalClosePrice() {
        return this.legalClosePrice;
    }

    public void setLegalClosePrice(LegalClosePrice legalClosePrice) {
        this.legalClosePrice = legalClosePrice;
    }

    LegalClosePrice legalClosePrice;

    @JsonProperty("WAPRICE")
    public WaPrice getWaPrice() {
        return this.waPrice;
    }

    public void setWaPrice(WaPrice waPrice) {
        this.waPrice = waPrice;
    }

    WaPrice waPrice;

    @JsonProperty("CLOSE")
    public Close getClose() {
        return this.close;
    }

    public void setClose(Close close) {
        this.close = close;
    }

    Close close;

    @JsonProperty("VOLUME")
    public Volume getVolume() {
        return this.volume;
    }

    public void setVolume(Volume volume) {
        this.volume = volume;
    }

    Volume volume;

    @JsonProperty("MARKETPRICE2")
    public MarketPrice2 getMarketPrice2() {
        return this.marketPrice2;
    }

    public void setMarketPrice2(MarketPrice2 marketPrice2) {
        this.marketPrice2 = marketPrice2;
    }

    MarketPrice2 marketPrice2;

    @JsonProperty("MARKETPRICE3")
    public MarketPrice3 getMarketPrice3() {
        return this.marketPrice3;
    }

    public void setMarketPrice3(MarketPrice3 marketPrice3) {
        this.marketPrice3 = marketPrice3;
    }

    MarketPrice3 marketPrice3;

    @JsonProperty("ADMITTEDQUOTE")
    public AdmittedQuote getAdmittedQuote() {
        return this.admittedQuote;
    }

    public void setAdmittedQuote(AdmittedQuote admittedQuote) {
        this.admittedQuote = admittedQuote;
    }

    AdmittedQuote admittedQuote;

    @JsonProperty("MP2VALTRD")
    public MP2VALTRD getMP2VALTRD() {
        return this.mP2VALTRD;
    }

    public void setMP2VALTRD(MP2VALTRD mP2VALTRD) {
        this.mP2VALTRD = mP2VALTRD;
    }

    MP2VALTRD mP2VALTRD;

    @JsonProperty("MARKETPRICE3TRADESVALUE")
    public MarketPrice3TradesValue getMarketPrice3TradesValue() {
        return this.marketPrice3TradesValue;
    }

    public void setMarketPrice3TradesValue(MarketPrice3TradesValue marketPrice3TradesValue) {
        this.marketPrice3TradesValue = marketPrice3TradesValue;
    }

    MarketPrice3TradesValue marketPrice3TradesValue;

    @JsonProperty("ADMITTEDVALUE")
    public AdmittedValue getAdmittedValue() {
        return this.admittedValue;
    }

    public void setAdmittedValue(AdmittedValue admittedValue) {
        this.admittedValue = admittedValue;
    }

    AdmittedValue admittedValue;

    @JsonProperty("WAVAL")
    public Waval getWaval() {
        return this.waval;
    }

    public void setWaval(Waval waval) {
        this.waval = waval;
    }

    Waval waval;

    @JsonProperty("TRADINGSESSION")
    public TradingSession getTradingSession() {
        return this.tradingSession;
    }

    public void setTradingSession(TradingSession tradingSession) {
        this.tradingSession = tradingSession;
    }

    TradingSession tradingSession;

    @JsonProperty("INDEX")
    public Index getIndex() {
        return this.index;
    }

    public void setIndex(Index index) {
        this.index = index;
    }

    Index index;

    @JsonProperty("TOTAL")
    public Total getTotal() {
        return this.total;
    }

    public void setTotal(Total total) {
        this.total = total;
    }

    Total total;

    @JsonProperty("PAGESIZE")
    public PageSize getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(PageSize pageSize) {
        this.pageSize = pageSize;
    }

    PageSize pageSize;
}
