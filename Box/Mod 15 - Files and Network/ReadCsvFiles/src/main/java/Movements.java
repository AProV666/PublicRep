import com.opencsv.CSVReader;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.*;

public class Movements {

    private String accountType;
    private String accountNumber;
    private String currency;
    private Date dateOfOperation;
    private String wiringReference;
    private String operationDescription;
    private Double arrivalOfMoney;
    private Double spendingOfMoney;
    private List<Movements> parsingList;
    private List<String[]> orgList;

    private Movements(String accountType, String accountNumber, String currency,
                      Date dateOfOperation, String wiringReference, String operationDescription,
                      Double arrivalOfMoney, Double spendingOfMoney) {
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.dateOfOperation = dateOfOperation;
        this.wiringReference = wiringReference;
        this.operationDescription = operationDescription;
        this.arrivalOfMoney = arrivalOfMoney;
        this.spendingOfMoney = spendingOfMoney;
    }

    public Movements(String pathMovementsCsv) {
        parsingFile(pathMovementsCsv);
        parsingLine();
    }

    public double getExpenseSum() {
        double expenseSum = 0;
        for (Movements x : parsingList) {
            expenseSum += x.getSpendingOfMoney();
        }
        return expenseSum;
    }

    public double getIncomeSum() {
        double incomeSum = 0;
        for (Movements x : parsingList) {
            incomeSum += x.getArrivalOfMoney();
        }
        return incomeSum;
    }

    private void parsingFile(String path) {
        parsingList = new ArrayList<>();
        try {
            FileReader filereader = new FileReader(path);
            CSVReader csvReader = new CSVReader(filereader);
            List<String[]> myEntries = csvReader.readAll();
            myEntries.remove(0);
            String dateFormat = "dd.MM.yy";
            for (String[] x : myEntries) {
                x[6] = x[6].replaceAll(",", ".");
                x[7] = x[7].replaceAll(",", ".");
                parsingList.add(new Movements(x[0], x[1], x[2],
                        (new SimpleDateFormat(dateFormat)).parse(x[3]),
                        x[4], x[5], Double.parseDouble(x[6]), Double.parseDouble(x[7])));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void parsingLine() {
        orgList = new ArrayList<>();

        for (Movements x : parsingList) {

            String line1 = x.getOperationDescription();

            String regex1 = "\\d{6}[+]{6}\\d{4}";
            String regex2 = "\\d{2}[.]\\d{2}[.]\\d{2}";
            String regex3 = "\\d{1,100}[.]\\d{2}";
            String regexRur = "RUR";
            String regexEur = "EUR";
            String regexUsd = "USD";

            String[] listArray = line1.split("\\s+");
            String arrayToString = "";

            for (int i = 0; i < listArray.length; i++) {
                if (listArray[i].matches(regex2) || listArray[i].matches(regex1)) {
                    listArray[i] = "";
                }
                if (listArray[i].matches(regexRur)
                        || listArray[i].matches(regexEur)
                        || listArray[i].matches(regexUsd)) {
                    for (int j = i + 1; j < listArray.length; j++) {
                        listArray[j] = "";
                    }
                }
                listArray[i] = listArray[i].replaceAll("[\\/><_]", " ");
                listArray[i] = listArray[i].trim();

            }

            arrayToString = String.join(" ", listArray);
            arrayToString = arrayToString.trim();

            String[] orgArray = arrayToString.split("\\s{2,5}");

            String[] companyAndExpenses = new String[3];
            companyAndExpenses[0] = orgArray[0];
            String w = orgArray[1].replaceAll(regexRur, "");
            w = w.replaceAll(regexEur, "");
            w = w.replaceAll(regexUsd, "");
            companyAndExpenses[1] = w;
            companyAndExpenses[2] = orgArray[1].replaceAll(regex3, "");

            for (int i = 0; i < companyAndExpenses.length; i++) {
                companyAndExpenses[i] = companyAndExpenses[i].trim();
            }
            orgList.add(companyAndExpenses);
        }
    }


    public void companyAndExpenses() {
        Set<String> treeSet = new TreeSet<>();

        for (String[] n : orgList) {
            treeSet.add(n[0]);
        }

        Double[] sum = new Double[treeSet.size()];
        String[] curr = new String[treeSet.size()];

        int num = 0;
        for (String l : treeSet) {
            double expenses = 0.0;
            String text = "";
            for (String[] h : orgList) {
                if (l.equals(h[0])) {
                    expenses = expenses + Double.parseDouble(h[1]);
                    text = h[2];
                }
            }
            sum[num] = expenses;
            curr[num] = text;
            num = num + 1;
        }

        int num2 = 0;
        System.out.println("Суммы расходов по организациям: ");
        for (String l : treeSet) {
            System.out.println(l + " = " + sum[num2] + " " + curr[num2]);
            num2 = num2 + 1;
        }
    }

    public String getAccountType() {
        return accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public Date getDateOfOperation() {
        return dateOfOperation;
    }

    public String getWiringReference() {
        return wiringReference;
    }

    public String getOperationDescription() {
        return operationDescription;
    }

    public Double getArrivalOfMoney() {
        return arrivalOfMoney;
    }

    public Double getSpendingOfMoney() {
        return spendingOfMoney;
    }

    @Override
    public String toString() {
        return accountType + " --- " + accountNumber + " --- " + currency + " --- " + dateOfOperation + " --- "
                + wiringReference + " --- " + operationDescription
                + " --- " + arrivalOfMoney + " --- " + spendingOfMoney;
    }
}