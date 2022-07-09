
import java.time.LocalDate;

public class DepositAccount extends BankAccount {
    private LocalDate put;
    private LocalDate lastIncome;

    @Override
    public void put(double amountToPut) {
        put = LocalDate.now().plusMonths(1);
        if (amountToPut > 0) {
            moneyAmount += amountToPut;
        } else {
            System.out.println("Ошибка пополнения");
        }
    }

    @Override
    public void take(double amountToTake) {
        lastIncome = LocalDate.now();
        if (amountToTake > 0 && amountToTake <= moneyAmount && (lastIncome.isEqual(put) || lastIncome.isAfter(put))) {
            moneyAmount -= amountToTake;
        }
    }
}


