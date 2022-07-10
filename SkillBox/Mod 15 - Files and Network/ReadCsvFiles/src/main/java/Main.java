public class Main {

    private static final String path = "src/main/resources/movementList.csv";

    public static void main(String[] args) {

        Movements movements = new Movements(path);
        System.out.println("Сумма расходов: " + movements.getExpenseSum() + " руб.");
        System.out.println("Сумма доходов: " + movements.getIncomeSum() + " руб.");
        movements.companyAndExpenses();
    }
}
