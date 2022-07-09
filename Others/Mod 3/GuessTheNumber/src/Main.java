import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int value = new Random().nextInt(100);
        String win = "Вы угадали!";
        String bigger = "Загаданное число больше";
        String smaller = "Загаданное число меньше";

        while (true) {
            int attempt = new Scanner(System.in).nextInt();
            if (attempt == value) {
                System.out.println(win);
                break;
            } else if (attempt < value) {
                System.out.println(bigger);
            } else {
                System.out.println(smaller);
            }
        }
    }
}
