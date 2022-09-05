package com.pro.springapp.service;

import com.pro.springapp.model.TickerPojo;

import java.util.List;

public interface MoexHistoryService {
    List<TickerPojo> getHistory(String ticker);
}
