public class IndividualBusinessman extends Client {
    private double commission1;
    private double commission2;

    @Override
    public void put(double amountToPut) {

        commission1 = amountToPut * 0.01;
        commission2 = commission1 * 0.5;

        if (amountToPut > 0 && amountToPut < 1000) {
            balance += (amountToPut - commission1);
        } else if (amountToPut >= 1000) {
            balance += (amountToPut - commission2);
        } else {
            System.out.println("Ошибка пополнения");
        }
    }

    @Override
    public void take(double amountToTake) {

        if (amountToTake <= balance) {
            balance -= amountToTake;
        }
    }
}
