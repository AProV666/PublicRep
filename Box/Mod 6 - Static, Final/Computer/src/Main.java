public class Main {

    public static void main(String[] args) {
        Computer computer = new Computer("Apple", "iMac Pro");

        computer.setCpu(3000, 18, "hyperX", 150);
        computer.setCpu(5000, 32, "hyperX", 300);

        computer.setRam("DDR4", 16, 75);
        computer.setInternalStorage("SSD", 1000, 200);
        computer.setDisplay(27, "IPS", 1000);
        computer.setKeyboard("Wireless", true, 350);

        System.out.println(computer);

        System.out.println("Общий вес компьютера: " + computer.computerWeight() + " гр.");
    }
}
