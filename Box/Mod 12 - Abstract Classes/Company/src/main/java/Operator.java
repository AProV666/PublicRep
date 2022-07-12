public class Operator implements Employee{

    private Company company;
    private double monthSalary;

    public Operator(Company company, double monthSalary) {
        this.company = company;
        this.monthSalary = monthSalary;
    }

    @Override
    public double getMonthSalary() {
        return (int) monthSalary;
    }

    @Override
    public String toString() {
        return "Оператор, зарплата = " + monthSalary + " руб.";
    }
}
