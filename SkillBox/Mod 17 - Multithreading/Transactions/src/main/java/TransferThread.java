public class TransferThread implements Runnable {
    Bank bank;
    Account accountFrom;
    Account accountTo;
    long moneyAmount;
    String threadNum;

    public TransferThread(Bank bank, Account accountFrom, Account accountTo, long moneyAmount, String threadNum) {
        this.bank = bank;
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.moneyAmount = moneyAmount;
        this.threadNum = threadNum;

    }

    @Override
    public void run() {
        bank.transfer(accountFrom.getAccNumber(), accountTo.getAccNumber(), moneyAmount);

        System.out.println("thread " + threadNum + ": " + bank.getBalance(accountFrom.getAccNumber()));
        System.out.println("thread " + threadNum + ": " + bank.getBalance(accountTo.getAccNumber()));

        long sumAllAccountsNew = bank.getSumAllAccounts();
        System.out.println("thread " + threadNum + ": " + "Общая сумма в банке: " + sumAllAccountsNew);
    }
}
