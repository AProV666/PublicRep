
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
        System.out.println(employeeMaxSalary);
    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {
        //TODO Метод должен вернуть сотрудника с максимальной зарплатой среди тех,
        // кто пришёл в году, указанном в переменной year

        int x = year - 1900;
        Date date1 = new Date(x - 1, Calendar.DECEMBER, 31);
        Date date2 = new Date(x + 1, Calendar.JANUARY, 1);

        List<Employee> employeeList = staff.stream()
                .filter(s -> s.getWorkStart().after(date1) && s.getWorkStart().before(date2))
                .sorted((e1, e2) -> e2.getSalary() - e1.getSalary())
                .limit(1).collect(Collectors.toList());

        return employeeList.get(0);
    }
}