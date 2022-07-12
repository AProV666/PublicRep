import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

public class Main {

    private static final SimpleDateFormat DF = new SimpleDateFormat("HH:mm:ss");
    private static final List<User> usersList = new ArrayList<>();
    private static final int MAX_USERS = 20;

    public static void main(String[] args) throws Exception {

        for (int i = 1; i <= MAX_USERS; i++) {
            usersList.add(new User(i, new Date()));
            Thread.sleep(1000);
        }

        int num = 0;
        int userBuySub = 0;
        int userBuySubCopy = 0;

        System.out.println("На главной странице показываем пользователя: " + usersList.get(num).getId()
                + " - Время регистрации: " + DF.format(usersList.get(num).getDateReg()));

        while (true) {
            if (num == 10) {
                userBuySub = new Random().nextInt(MAX_USERS - 1);
                System.out.println("Пользователь " + usersList.get(userBuySub).getId() + " оплатил платную услугу");
                System.out.println("На главной странице показываем пользователя: " + usersList.get(userBuySub).getId()
                        + " - Время регистрации: " + DF.format(usersList.get(userBuySub).getDateReg()));
                if (userBuySub != num) {
                    System.out.println("На главной странице показываем пользователя: " + usersList.get(num).getId()
                            + " - Время регистрации: " + DF.format(usersList.get(num).getDateReg()));
                }
                num++;
                Thread.sleep(500);
            } else if (num < 10 || num > 10 && num < 19) {
                if (usersList.get(num).getId() != usersList.get(userBuySub).getId()) {
                    System.out.println("На главной странице показываем пользователя: " + usersList.get(num).getId()
                            + " - Время регистрации: " + DF.format(usersList.get(num).getDateReg()));
                    Thread.sleep(500);
                }
                num++;
            } else {
                if (userBuySub != num) {
                    System.out.println("На главной странице показываем пользователя: " + usersList.get(num).getId()
                            + " - Время регистрации: " + DF.format(usersList.get(num).getDateReg()));
                }
                userBuySubCopy = new Random().nextInt(MAX_USERS - 1);
                System.out.println("Пользователь " + usersList.get(userBuySubCopy).getId() + " оплатил платную услугу");
                System.out.println("На главной странице показываем пользователя: "
                        + usersList.get(userBuySubCopy).getId() + " - Время регистрации: "
                        + DF.format(usersList.get(userBuySubCopy).getDateReg()));
                userBuySub = userBuySubCopy;
                num = 0;
                Thread.sleep(500);
                System.out.println("-----------------------------------------------------------------------------");
            }
        }
    }
}