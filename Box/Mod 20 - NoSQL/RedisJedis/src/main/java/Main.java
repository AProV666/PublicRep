import java.util.Date;

public class Main {

    public static void main(String[] args) throws Exception {

//для запуска сервиса
//brew services start redis
//для остановки
//brew services stop redis
//запуск клиента
//redis-cli
        String name = "Registration";

        RedisStorage redisStorage = new RedisStorage();
        redisStorage.init();

        for (int i = 0; i < 20; i++) {
            User user = new User(i + 1, new Date());
            redisStorage.addToRedis(name, user.getDateReg(), user.getId());
            Thread.sleep(1000);
        }

        int counter = 1;
        int userBuySub;
        int year = 1;

        while (true) {

            redisStorage.printFromRedis(name, 0, 1);
            int userNew = redisStorage.getUserFromRedis(name, 0, 1);
            redisStorage.addToRedis(name, new Date(), userNew);

            if (counter % 10 == 0) {
                userBuySub = redisStorage.randomRedis(name);
                System.out.println("Пользователь "
                        + redisStorage.getUserFromRedis(name, userBuySub, userBuySub + 1)
                        + " оплатил платную услугу");

                int userBuySub2 = redisStorage.getUserFromRedis(name, userBuySub, userBuySub + 1);
                redisStorage.addToRedis(name, new Date(2021 - year), userBuySub2);

                if (counter % 20 == 0) {
                    counter = 0;
                    System.out.println("----------------------------------------------");
                }
                year++;
            }
            Thread.sleep(1000);
            counter++;
        }
    }
}