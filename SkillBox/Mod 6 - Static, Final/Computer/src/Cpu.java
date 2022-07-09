public class Cpu {
    private final int speed;
    private final int coreAmount;
    private final String brand;
    private final int weight;

    public Cpu(int speed, int coreAmount, String brand, int weight) {
        this.speed = speed;
        this.coreAmount = coreAmount;
        this.brand = brand;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
        return "Частота: " + speed + ", Количество ядер: " + coreAmount + ", Производитель: " + brand + ", Вес: " + weight + " гр.";
    }
}
