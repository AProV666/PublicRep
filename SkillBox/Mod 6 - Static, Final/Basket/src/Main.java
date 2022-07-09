public class Main {
    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40);
        basket.print("Milk");

        basket.add("Bread", 10, 5, 1.5);
        basket.print("Basket #1");
        System.out.println("Total weight: " + basket.getTotalWeight() + " kg");
    }
}
