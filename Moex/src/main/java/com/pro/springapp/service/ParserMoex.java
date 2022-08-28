package com.pro.springapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pro.springapp.model.MoexPojo;
import com.pro.springapp.model.modelFromMoex.Root;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class ParserMoex {
    private Logger logger;

    public MoexPojo getBME(String jsonString) {

        List<String> boardsColumns = Collections.emptyList();
        List<ArrayList<Object>> boardsData = Collections.emptyList();

        ObjectMapper om = new ObjectMapper();

        try {
            Root rootMoex = om.readValue(jsonString, Root.class);
            boardsColumns = new ArrayList<>(rootMoex.getBoards().getColumns());
            boardsData = new ArrayList<>(rootMoex.getBoards().getData());
        } catch (IOException e) {
            e.printStackTrace();
        }

        int numBoard = 0;
        int numMarket = 0;
        int numEngine = 0;
        int numPrimary = 0;
        for (int i = 0; i < boardsColumns.size(); i++) {
            if (boardsColumns.get(i).equals("boardid")) {
                numBoard = i;
            }
            if (boardsColumns.get(i).equals("market")) {
                numMarket = i;
            }
            if (boardsColumns.get(i).equals("engine")) {
                numEngine = i;
            }
            if (boardsColumns.get(i).equals("is_primary")) {
                numPrimary = i;
            }
        }

        String boardId = "";
        String market = "";
        String engine = "";

        for (ArrayList<Object> dataList : boardsData) {
            if (dataList.get(numPrimary) instanceof Integer) {
                if ((int) dataList.get(numPrimary) == 1) {
                    boardId = dataList.get(numBoard).toString();
                    market = dataList.get(numMarket).toString();
                    engine = dataList.get(numEngine).toString();
                }
            } else {
                logger.warning("Invalid type!");
            }
        }
        return new MoexPojo(boardId, market, engine);
    }
}