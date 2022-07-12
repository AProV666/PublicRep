import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmailList {

    ArrayList<String> list = new ArrayList<>();

    public void add(String email) {
        // TODO: валидный формат email добавляется, email это строка, она быть может любой
        String regex  ="[abcdefghijklmnopqrstuvwxyz]+@[abcdefghijklmnopqrstuvwxyz]+[.]ru";
        String regex2  ="[abcdefghijklmnopqrstuvwxyz]+@[abcdefghijklmnopqrstuvwxyz]+[.]com";
        if(email.matches(regex)) {
            list.add(email);
        }
        else if(email.matches(regex2)) {
            list.add(email);
        } else {
            System.out.println("Не корректный email!");
        }
        }

    public List<String> getSortedEmails() {
        // TODO: возвращается сортированный список электронных адресов в алфавитном порядке
        Collections.sort(list);
        return list;
    }
}