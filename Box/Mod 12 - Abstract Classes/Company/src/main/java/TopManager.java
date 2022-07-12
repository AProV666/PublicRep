public class TopManager implements Employee{

    private Company company;
    private double monthSalary;
    private double income;

    public TopManager(Company company, double monthSalary) {
        this.company = company;
        income = company.getIncome();
        if(income > 10_000_000) {
            this.monthSalary = monthSalary + (monthSalary * 1.5);
        } else {
            this.monthSalary = monthSalary;
        }
    }

    @Override
    public double getMonthSalary() {
        return (int) monthSalary;
    }

    @Override
    public String toString() {
        return "ТопМенеджер, зарплата = " + monthSalary + " руб.";
    }
}
