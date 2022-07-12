import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Company company = new Company();

        List<Employee> listOperators = new ArrayList<>();
        for(int i = 0; i <= 180; i++) {
            listOperators.add(new Operator(company, 30000));
        }
        company.hireAll(listOperators);

        List<Employee> listManagers = new ArrayList<>();
        for(int i = 0; i <= 80; i++) {
            listManagers.add(new Manager(company, 50000));
        }
        company.hireAll(listManagers);

        List<Employee> listTopManagers = new ArrayList<>();
        for(int i = 0; i <= 10; i++) {
            listTopManagers.add(new TopManager(company, 100000));
        }
        company.hireAll(listTopManagers);

        System.out.println(company.getTopSalaryStaff(15));
        System.out.println(company.getLowestSalaryStaff(30));
        System.out.println("Прибыль компании: " + company.getIncome() + " руб.");

        for(int i = 0; i < company.getEmployeeList().size() / 2; i++) {
            company.fire(company.getEmployeeList().get(i));
        }

        System.out.println(company.getTopSalaryStaff(15));
        System.out.println(company.getLowestSalaryStaff(30));
        System.out.println("Прибыль компании: " + company.getIncome() + " руб.");

    }
}
