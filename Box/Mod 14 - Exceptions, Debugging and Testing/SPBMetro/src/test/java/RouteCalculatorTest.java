import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {

    String dataFile;
    StationIndex stationIndex;
    RouteCalculator calculator;
    List<Station> route;

    @Override
    protected void setUp() throws Exception {
        dataFile = "src/test/resources/mapCopy.json";
        calculator = getRouteCalculator();
        route = new ArrayList<>() {{
            add(stationIndex.getStation("Площадь Ленина"));
            add(stationIndex.getStation("Чернышевская"));
            add(stationIndex.getStation("Площадь Восстания"));
            add(stationIndex.getStation("Маяковская"));
            add(stationIndex.getStation("Гостиный двор"));
        }};
    }

    @Test
    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 11;
        assertEquals(expected, actual);
    }

    @Test
    public void testGetShortestRoute1() {

        List<Station> actual = calculator.getShortestRoute(stationIndex.getStation("Выборгская"),
                stationIndex.getStation("Владимирская"));
        List<Station> expected = new ArrayList<>() {{
            add(stationIndex.getStation("Выборгская"));
            add(stationIndex.getStation("Площадь Ленина"));
            add(stationIndex.getStation("Чернышевская"));
            add(stationIndex.getStation("Площадь Восстания"));
            add(stationIndex.getStation("Владимирская"));
        }};

        assertEquals(expected, actual);
    }

    @Test
    public void testGetShortestRoute2() {
        List<Station> actual = calculator.getShortestRoute(stationIndex.getStation("Площадь Ленина"),
                stationIndex.getStation("Гостиный двор"));
        List<Station> expected = new ArrayList<>() {{
            add(stationIndex.getStation("Площадь Ленина"));
            add(stationIndex.getStation("Чернышевская"));
            add(stationIndex.getStation("Площадь Восстания"));
            add(stationIndex.getStation("Маяковская"));
            add(stationIndex.getStation("Гостиный двор"));
        }};

        assertEquals(expected, actual);
    }

    @Test
    public void testGetShortestRoute3() {
        List<Station> actual = calculator.getShortestRoute(stationIndex.getStation("Чернышевская"),
                stationIndex.getStation("Горьковская"));
        List<Station> expected = new ArrayList<>() {{
            add(stationIndex.getStation("Чернышевская"));
            add(stationIndex.getStation("Площадь Восстания"));
            add(stationIndex.getStation("Маяковская"));
            add(stationIndex.getStation("Гостиный двор"));
            add(stationIndex.getStation("Невский проспект"));
            add(stationIndex.getStation("Горьковская"));
        }};

        assertEquals(expected, actual);
    }


    private RouteCalculator getRouteCalculator() {
        createStationIndex();
        return new RouteCalculator(stationIndex);
    }

    private void createStationIndex() {
        stationIndex = new StationIndex();
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonData = (JSONObject) parser.parse(getJsonFile());

            JSONArray linesArray = (JSONArray) jsonData.get("lines");
            parseLines(linesArray);

            JSONObject stationsObject = (JSONObject) jsonData.get("stations");
            parseStations(stationsObject);

            JSONArray connectionsArray = (JSONArray) jsonData.get("connections");
            parseConnections(connectionsArray);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void parseConnections(JSONArray connectionsArray) {
        connectionsArray.forEach(connectionObject ->
        {
            JSONArray connection = (JSONArray) connectionObject;
            List<Station> connectionStations = new ArrayList<>();
            connection.forEach(item ->
            {
                JSONObject itemObject = (JSONObject) item;
                int lineNumber = ((Long) itemObject.get("line")).intValue();
                String stationName = (String) itemObject.get("station");

                Station station = stationIndex.getStation(stationName, lineNumber);
                if (station == null) {
                    throw new IllegalArgumentException("core.Station " +
                            stationName + " on line " + lineNumber + " not found");
                }
                connectionStations.add(station);
            });
            stationIndex.addConnection(connectionStations);
        });
    }

    private void parseStations(JSONObject stationsObject) {
        stationsObject.keySet().forEach(lineNumberObject ->
        {
            int lineNumber = Integer.parseInt((String) lineNumberObject);
            Line line = stationIndex.getLine(lineNumber);
            JSONArray stationsArray = (JSONArray) stationsObject.get(lineNumberObject);
            stationsArray.forEach(stationObject ->
            {
                Station station = new Station((String) stationObject, line);
                stationIndex.addStation(station);
                line.addStation(station);
            });
        });
    }

    private void parseLines(JSONArray linesArray) {
        linesArray.forEach(lineObject -> {
            JSONObject lineJsonObject = (JSONObject) lineObject;
            Line line = new Line(
                    ((Long) lineJsonObject.get("number")).intValue(),
                    (String) lineJsonObject.get("name")
            );
            stationIndex.addLine(line);
        });
    }

    private String getJsonFile() {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(dataFile));
            lines.forEach(line -> builder.append(line));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }
}

