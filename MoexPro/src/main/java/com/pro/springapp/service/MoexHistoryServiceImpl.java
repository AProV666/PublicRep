package com.pro.springapp.service;

import com.pro.springapp.model.MoexPojo;
import com.pro.springapp.model.TickerPojo;
import com.pro.springapp.model.TickerPojoForDB;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

@Component("moexHistoryServiceImpl")
public class MoexHistoryServiceImpl implements MoexHistoryService {

    @Override
    public List<TickerPojo> getHistory(String ticker) {

        long start = System.currentTimeMillis();

        List<TickerPojo> tickerPojoList;
        Set<Date> uniqDateList = new TreeSet<>();

        DataBase dataBase = new DataBase();
        dataBase.initializer("hibernate.cfg.xml");
        List<TickerPojoForDB> dbList = dataBase.getList();

        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        String date = formatter.format(new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000));

        boolean isNeedDB = false;
        for (TickerPojoForDB t : dbList) {
            String dateDB = formatter.format(t.getDate());
            if (ticker.equals(t.getTicker())) {
                uniqDateList.add(t.getDate());
            }
            if (ticker.equals(t.getTicker()) && date.equals(dateDB)) {
                isNeedDB = true;
            }
        }

        if (isNeedDB) {
            tickerPojoList = new ArrayList<>();
            for (TickerPojoForDB t : dbList) {
                if (ticker.equals(t.getTicker())) {
                    TickerPojo tickerPojo = new TickerPojo(formatter
                            .format(t.getDate()), t.getLow(), t.getHigh(), t.getClose(), t.getVolume());
                    tickerPojoList.add(tickerPojo);
                }
            }
        } else {
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

            ParserTickerMoex parserTickerMoex = new ParserTickerMoex(moexPOJO.getBoardId());
            tickerPojoList = new ArrayList<>(parserTickerMoex.tParser(tickerURL, ticker));

            int total = parserTickerMoex.getTotal();
            int pageSize = parserTickerMoex.getPageSize();

            for (int i = pageSize; i <= total; i += pageSize) {
                String nextTickerURL = baseURLForTicker + i;
                tickerPojoList.addAll(parserTickerMoex.tParser(nextTickerURL, ticker));
            }
        }

        dataBase.uniqTickerToDB(ticker, dataBase, uniqDateList, tickerPojoList);
        dataBase.closeSession();

        System.out.println(System.currentTimeMillis() - start);

        return tickerPojoList;
    }
}
