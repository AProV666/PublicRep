public class Ram {
    private final String type;
    private final int capacity;
    private final int weight;

    public Ram(String type, int capacity, int weight) {
        this.type = type;
        this.capacity = capacity;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
        return "Тип: " + type + ", Объем: " + capacity + " gb" + ", Вес: " + weight + " гр.";
    }
}
