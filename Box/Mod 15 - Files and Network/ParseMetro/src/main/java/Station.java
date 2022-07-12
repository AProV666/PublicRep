public class Station {
    private String nameStation;
    private String numberLine;

    public Station(String name, String numberLine) {
        this.nameStation = name;
        this.numberLine = numberLine;
    }

    public String getNameStation() {
        return nameStation;
    }

    public String getNumberLine() {
        return numberLine;
    }

    @Override
    public String toString() {
        return nameStation;
    }
}
