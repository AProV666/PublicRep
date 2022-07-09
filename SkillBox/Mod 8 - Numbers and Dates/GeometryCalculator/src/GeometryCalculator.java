public class GeometryCalculator {

    public double circleArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    public double triangleArea(double a, double b, double c) {
        double s = 0;
        if (a + b > c || a + c > b || b + c > a) {
            double p = (a + b + c) / 2;
            s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return s;
    }

    public double sphereVolume(double radius) {
        return (4 * Math.PI * Math.pow(radius, 3)) / 3;
    }
}