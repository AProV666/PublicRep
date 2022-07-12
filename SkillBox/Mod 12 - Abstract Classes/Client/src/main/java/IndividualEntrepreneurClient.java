public class IndividualEntrepreneurClient extends Client {

    @Override
    public String getName() {
        return "Индивидуальный предприниматель";
    }

    @Override
    public void put(double amount) {
        if (amount > 0 && amount < 1000) {
            double percent = amount * 0.01;
            super.moneyAmount = super.moneyAmount + amount - percent;
        }
        if (amount >= 1000) {
            double percent = amount * 0.005;
            super.moneyAmount = super.moneyAmount + amount - percent;
        }
    }
}
