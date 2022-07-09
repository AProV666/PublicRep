import java.util.List;

public class Main {
    public static void main(String[] args) {

        Company company = new Company();

        company.hireAll(new Operator(), 3);
        company.hireAll(new Manager(), 20);
        company.hireAll(new TopManager(company.getIncome()), 3);

        for (Employee x : company.staffList) {
            System.out.println(x);
        }
        System.out.println("\n");

        System.out.println("Доход компании: " + company.getIncome() + " руб.");

        System.out.println("\n");

        List<Employee> topList = company.getTopSalaryStaff(6);
        for (Employee x : topList) {
            System.out.println(x);
        }

        System.out.println("\n");

        List<Employee> lowestList = company.getLowestSalaryStaff(5);
        for (Employee x : lowestList) {
            System.out.println(x);
        }
    }
}
