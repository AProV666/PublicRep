import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {

    List<Employee> staffList = new ArrayList<>();


    //найм одного сотрудника
    public void hire(Employee employee) {
        staffList.add(employee);
    }

    //найм списка сотрудника
    public void hireAll(Employee employee, int amount) {

        if (employee instanceof Operator) {
            for (int i = 0; i < amount; i++) {
                staffList.add(new Operator());
            }
        }

        if (employee instanceof Manager) {
            for (int i = 0; i < amount; i++) {
                staffList.add(new Manager());
            }
        }

        if (employee instanceof TopManager) {
            for (int i = 0; i < amount; i++) {
                staffList.add(new TopManager(getIncome()));
            }
        }
    }

    //увольнение одного сотрудника
    public void fire(int index) {
        for (int i = 0; i < index; i++) {
            staffList.remove(staffList.size() - 1);
        }
    }

    //получение значения дохода компании
    public int getIncome() {
        int sum = 0;
        for (Employee x : staffList) {
            if (x instanceof Manager) {
                sum += ((Manager) x).getProfit();
            }
        }
        return sum;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        List<Employee> topSalaryList = new ArrayList<>();
        Collections.sort(staffList, (Employee obj1, Employee obj2) -> obj1.getMonthSalary() - obj2.getMonthSalary());
        for (int i = 0; i < count; i++) {
            topSalaryList.add(staffList.get(staffList.size() - 1 - i));
        }
        return topSalaryList;
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        List<Employee> lowestSalaryList = new ArrayList<>();
        Collections.sort(staffList, (Employee obj1, Employee obj2) -> obj1.getMonthSalary() - obj2.getMonthSalary());
        for (int i = 0; i < count; i++) {
            lowestSalaryList.add(staffList.get(i));
        }
        return lowestSalaryList;
    }
}