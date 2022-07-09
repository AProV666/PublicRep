package strings;

import java.util.Scanner;

public class FullNameFormatter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                scanner.close();
                break;
            }
            String[] book = new String[input.length()];
            for (int i = 0; i < book.length; i++) {
                char x = input.charAt(i);
                String joke = String.valueOf(x);
                book[i] = joke;
            }
            String str1 = "";
            for (int i = 0; i < book.length; i++) {
                if (book[i].equals(" ")) {
                    break;
                } else {
                    str1 = str1 + book[i];
                }
            }
            String str2 = "";
            for (int i = str1.length() + 1; i < book.length; i++) {
                if (book[i].equals(" ")) {
                    break;
                } else {
                    str2 = str2 + book[i];
                }
            }
            String str3 = "";
            for (int i = str1.length() + 1 + str2.length() + 1; i < book.length; i++) {
                if (book[i].equals(" ")) {
                    break;
                } else {
                    str3 = str3 + book[i];
                }
            }
            String str4 = "";
            for (int i = str1.length() + 1 + str2.length() + 1 + str3.length() + 1; i < book.length; i++) {
                if (book[i].equals(" ")) {
                    break;
                } else {
                    str4 = str4 + book[i];
                }
            }
            boolean isSym = false;
            for (int i = 0; i < input.length(); i++) {
                char symbol = input.charAt(i);
                boolean isDigit = Character.isDigit(symbol);
                if (isDigit) {
                    isSym = true;
                    break;
                }
            }
            if (isSym || str4 != "" || str1 == "" || str2 == "" || str3 == "") {
                System.out.println("Введенная строка не является ФИО");
            } else {
                System.out.print("Фамилия: " + str1 + "\n" + "Имя: " + str2 + "\n" + "Отчество: " + str3 + "\n");
            }
        }
    }
}