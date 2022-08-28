package com.pro.springapp.service;

import com.pro.springapp.model.MoexPojo;
import com.pro.springapp.model.TickerPojo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("moexHistoryServiceImpl")
public class MoexHistoryServiceImpl implements MoexHistoryService {

    @Override
    public List<TickerPojo> getHistory(String ticker) {

        long start = System.currentTimeMillis();

        String baseURL = "https://iss.moex.com/iss";

        String moexURL = String.format("%s/securities/%s.json", baseURL, ticker);
        HttpClientUtils httpClientUtils = new HttpClientUtils();
        String jsonStringMoex = httpClientUtils.httpGet(moexURL);
        ParserMoex parserMoex = new ParserMoex();
        MoexPojo moexPOJO = parserMoex.getBME(jsonStringMoex);

        String baseURLForTicker =
                String.format("%s/history/engines/%s/markets/%s/securities/%s.json?start=",
                        baseURL, moexPOJO.getEngine(), moexPOJO.getMarket(), ticker);
        String tickerURL = baseURLForTicker + 0;

        ToDB toDB = new ToDB();
        toDB.initializer("hibernate.cfg.xml");

        ParserTickerMoex parserTickerMoex = new ParserTickerMoex(moexPOJO.getBoardId());
        ArrayList<TickerPojo> tickerPojoList = new ArrayList<>(parserTickerMoex.tParser(tickerURL, ticker, toDB));

        int total = parserTickerMoex.getTotal();
        int pageSize = parserTickerMoex.getPageSize();

        for (int i = pageSize; i <= total; i += pageSize) {
            String nextTickerURL = baseURLForTicker + i;
            tickerPojoList.addAll(parserTickerMoex.tParser(nextTickerURL, ticker, toDB));
        }

        toDB.closeSession();

        System.out.println(System.currentTimeMillis() - start);

        return tickerPojoList;
    }
}
