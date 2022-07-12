public class Main {

    public static void main(String[] args) {

        DepositAccount depositAccount = new DepositAccount();
        System.out.println(depositAccount.getAmount());

        depositAccount.put(3.0);
        System.out.println(depositAccount.getAmount());

        depositAccount.take(1.0);
        System.out.println(depositAccount.getAmount());

    }
}
