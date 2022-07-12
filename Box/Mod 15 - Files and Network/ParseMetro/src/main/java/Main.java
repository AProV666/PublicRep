import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String webSiteURL = "https://skillbox-java.github.io";
        String pathToJson = "src/main/resources/metro.json";

        List<Line> linesList = jsoupParser(webSiteURL);
        writeToJson(linesList, pathToJson);
        readFromJson(pathToJson);
    }

    public static List<Line> jsoupParser(String webSiteURL) {
        List<Line> linesList = new ArrayList<>();
        List<String> stringLinesList = new ArrayList<>();
        List<String> stringStationsList = new ArrayList<>();

        try {
            Document doc = Jsoup.connect(webSiteURL).maxBodySize(0).get();
            //названия линий
            Elements elemLines = doc.select("div.js-toggle-depend.s-depend-control-single");
            elemLines.forEach(element -> stringLinesList.add(element.text()));
            //все станции всех линий
            Elements elemStations = doc.select("div[data-line]");
            elemStations.forEach(element -> stringStationsList.add(element.text()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < stringLinesList.size(); i++) {
            String n = String.valueOf(i + 1);
            if (i + 1 == 16) {
                n = "D1";
            }
            if (i + 1 == 17) {
                n = "D2";
            }
            List<Station> stationsList = getStationsList(stringStationsList.get(i), n);
            linesList.add(new Line(stringLinesList.get(i), n, stationsList));
        }
        return linesList;
    }

    public static List<Station> getStationsList(String stringStationsList, String n) {
        List<Station> stationsList = new ArrayList<>();
        String[] stationsArray = stringStationsList.split("[0-9]+[.]");
        String[] newArray = Arrays.copyOfRange(stationsArray, 1, stationsArray.length);

        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = newArray[i].trim();
            stationsList.add(new Station(newArray[i], n));
        }
        return stationsList;
    }

    public static void writeToJson(List<Line> jsoupFile, String path) {
        try {
            PrintWriter writer = new PrintWriter(path);
            writer.write("{\n");
            writer.write("\t\"stations\": {\n");

            for (int i = 0; i < jsoupFile.size(); i++) {
                writer.write("\t\t\"" + jsoupFile.get(i).getNumberLine() + "\":\s[\n");

                if (i == jsoupFile.size() - 1) {
                    for (int j = 0; j < jsoupFile.get(i).getStationsList().size(); j++) {
                        if (j == jsoupFile.get(i).getStationsList().size() - 1) {
                            writer.write("\t\t\t\"" + jsoupFile.get(i).getStationsList().get(j) + "\"\n");
                            writer.write("\t\t]\n");
                        } else {
                            writer.write("\t\t\t\"" + jsoupFile.get(i).getStationsList().get(j) + "\",\n");
                        }
                    }
                } else {
                    for (int j = 0; j < jsoupFile.get(i).getStationsList().size(); j++) {
                        if (j == jsoupFile.get(i).getStationsList().size() - 1) {
                            writer.write("\t\t\t\"" + jsoupFile.get(i).getStationsList().get(j) + "\"\n");
                            writer.write("\t\t],\n");
                        } else {
                            writer.write("\t\t\t\"" + jsoupFile.get(i).getStationsList().get(j) + "\",\n");
                        }
                    }
                }
            }
            writer.write("\t},\n");

            writer.write("\t\"lines\":\s[\n");
            for (int i = 0; i < jsoupFile.size(); i++) {
                if (i == jsoupFile.size() - 1) {
                    writer.write("\t\t{\n\t\t\t\"number\":\s\"" + jsoupFile.get(i).getNumberLine() + "\",\n");
                    writer.write("\t\t\t\"name\":\s\"" + jsoupFile.get(i).getNameLine() + "\"\n" + "\t\t}\n");
                } else {
                    writer.write("\t\t{\n\t\t\t\"number\":\s\"" + jsoupFile.get(i).getNumberLine() + "\",\n");
                    writer.write("\t\t\t\"name\":\s\"" + jsoupFile.get(i).getNameLine() + "\"\n" + "\t\t},\n");
                }
            }
            writer.write("\t]\n");
            writer.write("}");
            writer.flush();
            writer.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static void readFromJson(String path) {
        try {
            Object obj = new JSONParser().parse(new FileReader(path));
            JSONObject jo = (JSONObject) obj;
            JSONArray linesArr = (JSONArray) jo.get("lines");
            JSONObject stationsObj = (JSONObject) jo.get("stations");
            Iterator linesItr = linesArr.iterator();

            while (linesItr.hasNext()) {
                JSONObject test = (JSONObject) linesItr.next();
                String[] str = stationsObj.get(test.get("number")).toString()
                        .replaceAll("[\"]", "")
                        .split("[,]");
                System.out.println(test.get("name") + " (" + test.get("number") + ")"
                        + " - количество станций: " + str.length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}