
public class Operator implements Employee {

    private int salary;
    private int ante = 45000;

    public Operator() {
        salary = ante;
    }

    public int getMonthSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Оператор зарабатывает - " + salary + " руб.";
    }
}

