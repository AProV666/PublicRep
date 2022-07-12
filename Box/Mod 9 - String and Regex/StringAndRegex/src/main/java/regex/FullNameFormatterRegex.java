package regex;

import java.util.Scanner;

public class FullNameFormatterRegex {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                scanner.close();
                break;
            }
            String[] words = input.split("\\s+");

            boolean isSym = false;

            for (int i = 0; i < input.length(); i++) {
                char symbol = input.charAt(i);
                boolean isDigit = Character.isDigit(symbol);
                if (isDigit) {
                    isSym = true;
                    break;
                }
            }

            if (isSym) {
                System.out.println("Введенная строка не является ФИО");
            } else if (words.length != 3) {
                System.out.println("Введенная строка не является ФИО");
            } else {
                System.out.print("Фамилия: " + words[0] + "\n" + "Имя: " + words[1] + "\n" + "Отчество: " + words[2] + "\n");
            }
        }
    }
}
