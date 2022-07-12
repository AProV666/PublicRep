import java.util.*;

public class PhoneBook {

    HashMap<String, String> book = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона
        // (рекомедуется написать отдельные методы для проверки является строка именем/телефоном)
        // если такой номер уже есть в списке, то перезаписать имя абонента
        if (book.containsKey(name) && formatPhone(phone)) {
            String phoneCopy = "";
            for (Map.Entry<String, String> entry : book.entrySet()) {
                String key = entry.getKey(); // получения ключа
                String value = entry.getValue(); // получения ключа
                if (key.equals(name)) {
                    phoneCopy = value + ", " + phone;
                }
            }
            book.put(name, phoneCopy);
        } else if (book.containsValue(phone) && formatName(name)) {
            String nameCopy = "";
            for (Map.Entry<String, String> entry : book.entrySet()) {
                String key = entry.getKey(); // получения ключа
                String value = entry.getValue(); // получения ключа
                if (phone.equals(value)) {
                    book.remove(key);
                }
            }
            book.put(name, phone);
        } else if (formatName(name) && formatPhone(phone)) {
            book.put(name, phone);
        } else {
            System.out.println("Ошибка ввода");
        }

    }

    public String getContactByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        String byPhone = "";
        if (book.containsValue(phone)) {
            for (Map.Entry<String, String> entry : book.entrySet()) {
                String key = entry.getKey(); // получения ключа
                String value = entry.getValue(); // получения ключа
                if (value.equals(phone)) {
                    System.out.println(key);
                    byPhone = key + " - " + phone;
                }
            }
        } else {
            System.out.println("Такого номера нет в телефонной книге.");
            System.out.println("Введите имя абонента для номера " + "\"" + phone + "\"" + ":");
            String input = scanner.nextLine();
            book.put(input, phone);
            System.out.println("Контакт сохранен!");
        }
        return byPhone;
    }

    public Set<String> getContactByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        Set<String> byName = new TreeSet<>();
        if (book.containsKey(name)) {
            String phone = "";
            for (Map.Entry<String, String> entry : book.entrySet()) {
                String key = entry.getKey(); // получения ключа
                String value = entry.getValue(); // получения ключа
                if (key.equals(name)) {
                    phone = value;
                }
            }
            byName.add(name + " - " + phone);
            System.out.println(book.get(name) + " - " + phone);
        } else {
            System.out.println("Такого имени в телефонной книге нет.");
            System.out.println("Введите номер телефона для абонента " + "\"" + name + "\"" + ":");
            String input = scanner.nextLine();
            input = formatPhoneReplace(input);
            book.put(name, input);
            System.out.println("Контакт сохранен!");
        }
        return byName;
    }

    public Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        Set<String> allCont = new TreeSet<>();

        if (!book.isEmpty()) {
            for (Map.Entry<String, String> entry : book.entrySet()) {
                String key = entry.getKey(); // получения ключа
                String value = entry.getValue(); // получения ключа
                allCont.add(key + " - " + value);
            }
            for (String s : allCont) {
                System.out.println(s);
            }
        }
        return allCont;
    }


    // для обхода Map используйте получение пары ключ->значение Map.Entry<String,String>
    // это поможет вам найти все ключи (key) по значению (value)
    /*
        for (Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey(); // получения ключа
            String value = entry.getValue(); // получения ключа
        }
    */

    public String formatPhoneReplace(String phone) {
        String regex = "[^0-9]";
        return phone.replaceAll(regex, "");
    }

    public boolean formatName(String name) {
        String regex = "[абвгдеёжзийклмнопрстуфхчшщъьэюя]{1,100}";
        String nameCopy = name.toLowerCase();
        return nameCopy.matches(regex);
    }

    public boolean formatPhone(String phone) {
        String regex = "[0-9]{11}";
        String phoneCopy = formatPhoneReplace(phone);
        return phoneCopy.matches(regex);
    }
}