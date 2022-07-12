import java.util.*;

public class Company {

    private List<Employee> employeeList = new ArrayList<>();
    private double income;

    public void hire(Employee employee) {
        employeeList.add(employee);
    }

    public void hireAll(List<Employee> employes) {
        employeeList.addAll(employes);
    }

    public void fire(Employee employee) {
        employeeList.remove(employee);
    }

    public int getIncome() {
        return (int) income;
    }

    void setIncome(double amount) {
        income += amount;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        List<Employee> list = new ArrayList<>();
        employeeList.sort(Comparator.comparing(Employee::getMonthSalary));
        for(int i = 0; i < count; i++) {
            list.add(employeeList.get(employeeList.size() - i - 1));
        }
        return list;

    }

    public List<Employee> getLowestSalaryStaff(int count) {
        List<Employee> list = new ArrayList<>();
        employeeList.sort(Comparator.comparing(Employee::getMonthSalary));
        for(int i = 0; i < count; i++) {
            list.add(employeeList.get(i));
        }
        return list;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}
