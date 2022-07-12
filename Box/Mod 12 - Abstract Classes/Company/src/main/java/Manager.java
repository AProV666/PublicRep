public class Manager implements Employee{

    private Company company;
    private double monthSalary;
    private double income;

    public Manager(Company company, double monthSalary) {
        this.company = company;
        income = (Math.random() * 25000) + 115000;
        company.setIncome(income);
        this.monthSalary = monthSalary + (income * 0.05);
    }

    @Override
    public double getMonthSalary() {
        return (int) monthSalary;
    }

    public double getIncome() {
        return income;
    }

    @Override
    public String toString() {
        return "Менеджер, зарплата = " + (int) monthSalary + " руб.";
    }
}
