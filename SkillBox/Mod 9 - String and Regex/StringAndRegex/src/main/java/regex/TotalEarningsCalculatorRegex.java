package regex;

public class TotalEarningsCalculatorRegex {

    public static void main(String[] args) {
        String text = "Вова зарабатывает 60000 рублей,а Оля 90000 рублей, а Андрей 130000!";
        System.out.println(calculateSalarySum(text));
    }

    public static int calculateSalarySum(String text) {
        String regex = "[^0-9]";
        String[] words = text.split("\\s+");
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            String x = words[i];
            words[i] = x.replaceAll(regex, "");
        }
        for (int i = 0; i < words.length; i++) {
            if (words[i] == "") {
                continue;
            }
            count += Integer.parseInt(words[i]);
        }
        return count;
    }
}
