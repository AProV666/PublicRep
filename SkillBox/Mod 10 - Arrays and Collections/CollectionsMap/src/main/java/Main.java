import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        String regex = "[0-9]{11}";
        while (true) {
            System.out.println("Введите номер, имя или команду:");
            String text = scanner.nextLine();

            if (text.equals("LIST")) {
                Set<String> book = phoneBook.getAllContacts();
                break;
            } else if (phoneBook.formatPhone(text)) {
                String byPhone = phoneBook.getContactByPhone(text);
            } else {
                Set<String> byName = phoneBook.getContactByName(text);
            }
        }
        phoneBook.addContact("8(916)808-58-14", "Андрей");
    }
}