import java.util.List;

public class Line {
    private String nameLine;
    private String numberLine;
    private List<Station> stationsList;

    public Line(String nameLine, String numberLine, List<Station> stationsList) {
        this.nameLine = nameLine;
        this.numberLine = numberLine;
        this.stationsList = stationsList;
    }

    public String getNameLine() {
        return nameLine;
    }

    public String getNumberLine() {
        return numberLine;
    }

    public List<Station> getStationsList() {
        return stationsList;
    }

    @Override
    public String toString() {
        return nameLine + "\n\tНомер линии: " + numberLine + "\n\t\tСтанции: " + stationsList + "\n";
    }
}

