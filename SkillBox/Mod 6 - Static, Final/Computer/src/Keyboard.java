public class Keyboard {
    private final String type;
    private final boolean hasBacklight;
    private final int weight;

    public Keyboard(String type, boolean hasBacklight, int weight) {
        this.type = type;
        this.hasBacklight = hasBacklight;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
        return "Тип: " + type + ", Наличие подсветки: " + (hasBacklight == true ? "Есть" : "Нет") + ", Вес: " + weight + " гр.";
    }
}
