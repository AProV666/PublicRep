public class Main {
    public static void main(String[] args) {
        Arithmetic arithmetic = new Arithmetic(5, 9);
        int sum = arithmetic.sum();
        int multi = arithmetic.multiplication();
        int max = arithmetic.max();
        int min = arithmetic.min();

        System.out.println(sum);
        System.out.println(multi);
        System.out.println(max);
        System.out.println(min);
    }
}
