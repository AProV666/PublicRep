package regex;

import java.util.Scanner;

public class PhoneCleanerRegex {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                scanner.close();
                break;
            }

            String regex1 = "[^0-9]";
            String x = input.replaceAll(regex1, "");
            char num = x.charAt(0);
            String num1 = String.valueOf(num);
            int count = Integer.parseInt(num1);

            if (x.length() == 10) {
                System.out.println("7" + x);
            } else if (x.length() > 11 || x.length() < 10) {
                System.out.println("Неверный формат номера");
            } else if ((x.length() == 11 && count == 7)) {
                System.out.println(x);
            } else if ((x.length() == 11 && count == 8)) {
                String str = x.replaceFirst("[8]", "7");
                System.out.println(str);
            } else if ((x.length() == 11 && count != 7) || (x.length() == 11 && count != 8)) {
                System.out.println("Неверный формат номера");
            } else {
                System.out.println("Неверный формат номера");
            }
        }
    }
}
