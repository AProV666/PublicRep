public abstract class Client {

    double moneyAmount;

    public double getAmount() {
        return moneyAmount;
    }

    public void put(double amount) {
        if (amount > 0) {
            moneyAmount += amount;
        }
    }

    public void take(double amount) {
        if(amount <= moneyAmount && amount > 0) {
            moneyAmount -= amount;
        }
    }

    abstract String getName();
}
