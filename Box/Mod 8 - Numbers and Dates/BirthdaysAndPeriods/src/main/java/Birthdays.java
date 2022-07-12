import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Birthdays {
    public static void main(String[] args) {
        int day = 31;
        int month = 12;
        int year = 1990;
        System.out.println(collectBirthdays(year, month, day));
    }

    public static String collectBirthdays(int year, int month, int day) {

        LocalDate birthday = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" - dd.MM.yyyy - ccc").localizedBy(new Locale("us"));
        LocalDate date = birthday;
        String text = "";
        for (int i = 0; date.isBefore(today) || date.isEqual(today); i++) {

            text = text + "\n" + i + formatter.format(birthday);
            date = date.plusYears(1);
            if (date.isBefore(today)) {
                birthday = date;
            } else if (birthday.equals(today.minusYears(1))) {
                birthday = birthday.plusYears(1);
            }
        }
        return text;
    }
}
