public class PhysicalPerson extends Client {

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
        if (amountToTake <= balance) {
            balance -= amountToTake;
        }
    }
}
