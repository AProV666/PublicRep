public class ArithmeticCalculator {
    private final int x;
    private final int y;

    public ArithmeticCalculator(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int calculate(Operation name) {
        if (name == Operation.ADD) {
            return x + y;
        } else if (name == Operation.SUBTRACT) {
            return x - y;
        } else {
            return x * y;
        }
    }


}
