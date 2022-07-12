public class CompanyClient extends Client {

    @Override
    public String getName() {
        return "Юридическое лицо";
    }

    @Override
    public void take(double amount) {
        double percent = amount * 0.01;
        if ((amount + percent) <= super.moneyAmount && amount > 0) {
            super.moneyAmount = super.moneyAmount - (amount + percent);
        }
    }
}
