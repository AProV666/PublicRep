
public class Manager implements Employee {

    private int salary;
    private int profit;
    private int ante = 50000;

    public Manager() {
        profit = 115000 + (int) (Math.random() * 25000);
        salary = ante + (int) (profit * 0.05);
    }

    public int getMonthSalary() {
        return salary;
    }

    public int getProfit() {
        return profit;
    }

    @Override
    public String toString() {
        return "Менеджер зарабатывает - " + salary + " руб.";
    }
}
