public class Display {
    private final int diagonal;
    private final String type;
    private final int weight;

    public Display(int diagonal, String type, int weight) {
        this.diagonal = diagonal;
        this.type = type;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
        return "Диагональ: " + diagonal + "\"" + ", Тип матрицы: " + type + ", Вес: " + weight + " гр.";
    }
}
