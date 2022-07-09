public class Dimensions {
    private final double width;
    private final double height;
    private final double length;

    public Dimensions(double length, double width, double height) {
        this.width = width;
        this.height = height;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }

    public double volume() {
        return width * height * length;
    }

    public Dimensions setWidth(double width) {
        return new Dimensions(length, width, height);
    }

    public Dimensions setHeight(double height) {
        return new Dimensions(length, width, height);
    }

    public Dimensions setLength(double length) {
        return new Dimensions(length, width, height);
    }

    @Override
    public String toString() {
        return "Длина: " + length + " см" + "\n" + "Ширина: " + width + " см" + "\n" + "Высота: " + height + " см";
    }
}
