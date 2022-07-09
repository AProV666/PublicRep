
public class TopManager implements Employee {
    private int salary;
    private int ante = 100_000;
    private int profit;

    public TopManager(int profit) {
        if (profit > 10_000_000) {
            salary = ante + (int) (ante * 1.5);
        } else {
            salary = ante;
        }
        this.profit = profit;
    }

    public int getMonthSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "ТопМенеджер зарабатывает - " + salary + " руб.";
    }


}
