public class Main {
    public static void main(String[] args) {
        IndividualEntrepreneurClient individual = new IndividualEntrepreneurClient();
        CompanyClient company = new CompanyClient();
        PhysicalPersonClient physical = new PhysicalPersonClient();

        System.out.println(individual.getName());
        individual.put(100);
        System.out.println(individual.getAmount());
        individual.take(50);
        System.out.println(individual.getAmount());

        System.out.println(company.getName());
        company.put(100);
        System.out.println(company.getAmount());
        company.take(50);
        System.out.println(company.getAmount());


        System.out.println(physical.getName());
        physical.put(100);
        System.out.println(physical.getAmount());
        physical.take(50);
        System.out.println(physical.getAmount());


    }
}
