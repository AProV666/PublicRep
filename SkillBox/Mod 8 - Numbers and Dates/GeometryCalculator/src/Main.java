public class Main {
    public static void main(String[] args) {
        GeometryCalculator geometryCalculator = new GeometryCalculator();

        System.out.println(geometryCalculator.circleArea(5));

        System.out.println(geometryCalculator.triangleArea(3, 4.5, 5));

        System.out.println(geometryCalculator.sphereVolume(5));
    }
}