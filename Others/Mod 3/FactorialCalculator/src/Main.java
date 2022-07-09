import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int value = new Scanner(System.in).nextInt();
        int valueSum = 1;
        int value1;

        int[] fact = new int[value];

        for (int i = 1; i <= value; i++) {
            value1 = i;
            valueSum *= value1;
            fact[i - 1] = i;
        }

        System.out.print(value + "! = ");

        for (int i = 0; i < fact.length; i++) {
            if (fact[i] != value) {
                System.out.print(fact[i] + " x ");
            } else {
                System.out.print(fact[i] + " = " + valueSum);
            }
        }
    }
}