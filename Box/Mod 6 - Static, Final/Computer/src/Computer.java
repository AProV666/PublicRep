public class Computer {
    private Cpu cpu;
    private Ram ram;
    private InternalStorage internalStorage;
    private Display display;
    private Keyboard keyboard;

    private final String vendor;
    private final String name;

    public Computer(String vendor, String name) {
        this.vendor = vendor;
        this.name = name;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public Ram getRam() {
        return ram;
    }

    public InternalStorage getInternalStorage() {
        return internalStorage;
    }

    public Display getDisplay() {
        return display;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setCpu(int speed, int coreAmount, String brand, int weight) {
        cpu = new Cpu(speed, coreAmount, brand, weight);
    }

    public void setRam(String type, int capacity, int weight) {
        ram = new Ram(type, capacity, weight);
    }

    public void setInternalStorage(String type, int capacity, int weight) {
        internalStorage = new InternalStorage(type, capacity, weight);
    }

    public void setDisplay(int diagonal, String type, int weight) {
        display = new Display(diagonal, type, weight);
    }

    public void setKeyboard(String type, boolean hasBacklight, int weight) {
        keyboard = new Keyboard(type, hasBacklight, weight);
    }

    public int computerWeight() {
        return cpu.getWeight() + ram.getWeight() + internalStorage.getWeight()
                + display.getWeight() + keyboard.getWeight();
    }

    public String toString() {
        return "Характеристики компьютера: " + "\n"
                + "Производитель: " + vendor + "\n"
                + "Название: " + name + "\n"
                + "Процессор: " + (cpu == null ? "нет данных" : cpu) + "\n"
                + "Оперативная память: " + (ram == null ? "нет данных" : ram) + "\n"
                + "Накопитель информации: " + (internalStorage == null ? "нет данных" : internalStorage) + "\n"
                + "Экран: " + (display == null ? "нет данных" : display) + "\n"
                + "Клавиатура: " + (keyboard == null ? "нет данных" : keyboard) + "\n";
    }
}
