public class BankAccount {
    protected double moneyAmount;

    public double getAmount() {
        return moneyAmount;
    }

    public void put(double amountToPut) {

        if (amountToPut > 0) {
            moneyAmount += amountToPut;
        } else {
            System.out.println("Ошибка пополнения");
        }
    }

    public void take(double amountToTake) {
        if (amountToTake <= 0 || amountToTake > moneyAmount) {
            System.out.println("Ошибка списания");
        } else {
            moneyAmount -= amountToTake;
        }
    }
}
