public class Main {
    public static void main(String[] args) {


        Bank bank = new Bank();

        Account account1 = new Account(105000, "111");
        Account account2 = new Account(95000, "222");
        Account account3 = new Account(85000, "333");
        Account account4 = new Account(75000, "444");
        Account account5 = new Account(65000, "555");
        Account account6 = new Account(55000, "666");

        bank.setAccounts(account1);
        bank.setAccounts(account2);
        bank.setAccounts(account3);
        bank.setAccounts(account4);
        bank.setAccounts(account5);
        bank.setAccounts(account6);

        System.out.println(bank.getBalance("111"));
        System.out.println(bank.getBalance("222"));

        TransferThread thread1 = new TransferThread(bank, account1, account2, 55000, "1");
        new Thread(thread1).start();

        System.out.println(bank.getBalance("111"));
        System.out.println(bank.getBalance("222"));


        TransferThread thread2 = new TransferThread(bank, account2, account1, 15000, "2");
        new Thread(thread2).start();
    }
}
