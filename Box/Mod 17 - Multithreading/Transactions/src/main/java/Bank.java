import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Bank {

    private Map<String, Account> accounts = new TreeMap<String, Account>();
    private final Random random = new Random();
    private volatile boolean securityService = false;

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount) {

        Account accountFrom = accounts.get(fromAccountNum);
        Account accountTo = accounts.get(toAccountNum);

        if (amount > 50000) {
            try {
                securityService = isFraud(fromAccountNum, toAccountNum, amount);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int fromId = Integer.parseInt(accountFrom.getAccNumber());
        int toId = Integer.parseInt(accountTo.getAccNumber());

        if (fromId < toId) {
            synchronized (accountFrom) {
                synchronized (accountTo) {

                    if (securityService == false) {
                        if (accountFrom.getMoney() >= amount) {
                            accountFrom.setMoney(accountFrom.getMoney() - amount);
                        } else {
                            System.out.println("На счете недостаточно средств!");
                        }

                        accountTo.setMoney(accountTo.getMoney() + amount);

                    } else {
                        System.out.println("Операция недоступна в связи с блокировкой счета!");
                    }
                }
            }
        } else {
            synchronized (accountTo) {
                synchronized (accountFrom) {

                    if (securityService == false) {
                        if (accountFrom.getMoney() >= amount) {
                            accountFrom.setMoney(accountFrom.getMoney() - amount);
                        } else {
                            System.out.println("На счете недостаточно средств!");
                        }

                        accountTo.setMoney(accountTo.getMoney() + amount);

                    } else {
                        System.out.println("Операция недоступна в связи с блокировкой счета!");
                    }
                }
            }
        }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        long sum = 0;
        for (Map.Entry<String, Account> account : accounts.entrySet()) {
            sum += account.getValue().getMoney();
        }
        return sum;
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Account account) {
        accounts.put(account.getAccNumber(), account);
    }
}
