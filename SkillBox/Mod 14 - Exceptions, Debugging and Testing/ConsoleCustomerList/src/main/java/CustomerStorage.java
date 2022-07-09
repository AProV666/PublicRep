import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");
        String regex1 = "[+]{1}[7]{1}[0-9]{10}";
        boolean isPhone = components[3].matches(regex1);
        String regex2 = "[abcdefghijklmnopqrstuvwxyz]+@[abcdefghijklmnopqrstuvwxyz]+[.]ru";
        String regex3 = "[abcdefghijklmnopqrstuvwxyz]+@[abcdefghijklmnopqrstuvwxyz]+[.]com";

        boolean isEmail1 = components[2].matches(regex2);
        boolean isEmail2 = components[2].matches(regex3);

        if (components.length != 4) {
            throw new RuntimeException("Неверный ввод данных!");
        } else if (!isEmail1 && !isEmail2) {
            throw new RuntimeException("Неверный формат почты!");
        } else if (!isPhone) {
            throw new RuntimeException("Неверный формат телефона!");
        } else {
            String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
            storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
        }

    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}