import redis.clients.jedis.Jedis;
import java.util.Date;

public class RedisStorage {
    private Jedis jedis;

    //подключение к редису
    void init() {
        try {
            jedis = new Jedis("redis://127.0.0.1:6379");
            System.out.println("Соединение установлено!");
            System.out.println("Служба работает: " + jedis.ping());
        } catch (Exception Ex) {
            System.out.println("Не удалось подключиться к Redis!");
            System.out.println(Ex.getMessage());
        }
    }

    //добавить юзера в редис
    void addToRedis(String name, Date date, int id) {
        String dateToString = String.valueOf(date.getTime() / 1000);
        jedis.zadd(name, Integer.parseInt(dateToString), String.valueOf(id));
    }

    //напечатать из редиса юзера
    void printFromRedis(String name, int index1, int index2) {
        String id = jedis.zrange(name, index1, index2).iterator().next();
        System.out.println("На главной странице показываем пользователя " + id);
    }

    //вернуть рандомного юзера из редиса
    int randomRedis(String name) {
        return Integer.parseInt(jedis.zrandmember(name));
    }

    //вернуть юзера из редиса
    int getUserFromRedis(String name, int index1, int index2) {
        String id = jedis.zrange(name, index1, index2).iterator().next();
        return Integer.parseInt(id);
    }
}
