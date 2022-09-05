package com.pro.springapp.controller;

import com.pro.springapp.service.MoexHistoryService;
import com.pro.springapp.model.TickerPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moex")
public class MoexController {

    private final MoexHistoryService moexHistoryService;

    @Autowired
    public MoexController(@Qualifier("moexHistoryServiceImpl") MoexHistoryService moexHistoryService){
        this.moexHistoryService = moexHistoryService;
    }

    @RequestMapping(value = "/{ticker}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TickerPojo> index(@PathVariable("ticker") String ticker) {
        ticker = ticker.toLowerCase();
        return moexHistoryService.getHistory(ticker);
    }
}
