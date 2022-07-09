
public class CardAccount extends BankAccount {

    @Override
    public void take(double amountToTake) {
        if (amountToTake <= 0 || amountToTake > super.moneyAmount) {
            System.out.println("Ошибка списания");
        } else {
            super.moneyAmount -= (amountToTake + (amountToTake * 0.01));
        }
    }
}
