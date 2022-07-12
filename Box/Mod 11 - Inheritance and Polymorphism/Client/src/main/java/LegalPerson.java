public class LegalPerson extends Client {
    private double commission;

    @Override
    public void put(double amountToPut) {
        if (amountToPut > 0) {
            balance += amountToPut;
        } else {
            System.out.println("Ошибка пополнения");
        }
    }

    @Override
    public void take(double amountToTake) {
        commission = amountToTake * 0.01;

        if ((amountToTake + commission) <= balance) {
            balance -= (amountToTake + commission);
        }
    }
}
