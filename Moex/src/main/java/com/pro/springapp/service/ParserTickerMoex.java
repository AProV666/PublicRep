package com.pro.springapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pro.springapp.model.TickerPojo;
import com.pro.springapp.model.TickerPojoForDB;
import com.pro.springapp.model.modelFromTicker.Root;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ParserTickerMoex {
    private final String boardId;
    private int total;
    private int pageSize;
    private ArrayList<TickerPojo> tickerList;

    public ParserTickerMoex(String boardId) {
        this.boardId = boardId;
    }

    public ArrayList<TickerPojo> tParser(String webSiteURLTicker, String ticker, ToDB toDB) {

        try {
            HttpClientUtils httpClientUtils = new HttpClientUtils();
            String json = httpClientUtils.httpGet(webSiteURLTicker);
            ObjectMapper om = new ObjectMapper();
            Root root = om.readValue(json, Root.class);

            tickerList = getInfoFromTicker(root, ticker, toDB);

            total = root.getHistoryCursor().getData().get(0).get(1);
            pageSize = root.getHistoryCursor().getData().get(0).get(2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //batch
        //конфиг подключения сделать бином
        //перед методом аннотацию транзакции
        //DAO слой на нем транзакция -число работа с базой - принимает и пихает в базу и падать если что/

        return tickerList;
    }

    public int getTotal() {
        return total;
    }

    public int getPageSize() {
        return pageSize;
    }


    public ArrayList<TickerPojo> getInfoFromTicker(Root root, String ticker, ToDB toDB) {

        ArrayList<String> columnsList = root.getHistory().getColumns();
        int numTradeDate = 0;
        int numLow = 0;
        int numHigh = 0;
        int numClose = 0;
        int numVolume = 0;
        for (int i = 0; i < root.getHistory().getColumns().size(); i++) {
            if (columnsList.get(i).equals("TRADEDATE")) {
                numTradeDate = i;
            }
            if (columnsList.get(i).equals("LOW")) {
                numLow = i;
            }
            if (columnsList.get(i).equals("HIGH")) {
                numHigh = i;
            }
            if (columnsList.get(i).equals("CLOSE")) {
                numClose = i;
            }
            if (columnsList.get(i).equals("VOLUME")) {
                numVolume = i;
            }
        }



        ArrayList<TickerPojo> tickerPojoList = new ArrayList<>();

        for (int i = 0; i < root.getHistory().getData().size(); i++) {
            String boardEq = String.valueOf(root.getHistory().getData().get(i).get(0));

            if (boardEq.equals(boardId)) {
                if(root.getHistory().getData().get(i).get(numLow) == null ||
                        root.getHistory().getData().get(i).get(numHigh) == null ||
                        root.getHistory().getData().get(i).get(numClose) == null) {
                    continue;
                }
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date dateSt = null;
                try {
                    dateSt = format.parse(String.valueOf(root.getHistory().getData().get(i).get(numTradeDate)));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

                String date = formatter.format(dateSt);
                Double low = Double.valueOf(String.valueOf(root.getHistory().getData().get(i).get(numLow)));
                Double high = Double.valueOf(String.valueOf(root.getHistory().getData().get(i).get(numHigh)));
                Double close = Double.valueOf(String.valueOf(root.getHistory().getData().get(i).get(numClose)));
                Integer volume = Integer.valueOf(String.valueOf(root.getHistory().getData().get(i).get(numVolume)));



                TickerPojo tickerPojo = new TickerPojo(date, low, high, close, volume);
                tickerPojoList.add(tickerPojo);



                TickerPojoForDB tickerPojoForDB = new TickerPojoForDB();
                tickerPojoForDB.setTicker(ticker);
                tickerPojoForDB.setDate(dateSt);
                tickerPojoForDB.setLow(low);
                tickerPojoForDB.setHigh(high);
                tickerPojoForDB.setClose(close);
                tickerPojoForDB.setVolume(volume);

                toDB.addToDB(tickerPojoForDB);



            }
        }
        return tickerPojoList;
    }
}