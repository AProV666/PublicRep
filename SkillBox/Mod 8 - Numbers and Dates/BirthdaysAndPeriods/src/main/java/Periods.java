import java.time.LocalDate;

public class Periods {
    public static void main(String[] args) {
        LocalDate java = LocalDate.of(1995, 5, 23);
        LocalDate now = LocalDate.of(2021, 11, 1);
        System.out.println(Periods.getPeriodFromBirthday(java, now));
    }

    public static String getPeriodFromBirthday(LocalDate firstDate, LocalDate secondDate) {

        int yearFirst = firstDate.getYear();
        int monthFirst = firstDate.getMonthValue();
        int dayFirst = firstDate.getDayOfMonth();

        int yearSecond = secondDate.getYear();
        int monthSecond = secondDate.getMonthValue();
        int daySecond = secondDate.getDayOfMonth();

        int yearSum = yearSecond - yearFirst;
        int monthSum = monthSecond - monthFirst;
        int daySum = daySecond - dayFirst;

        if (monthSum < 0) {
            yearSum = yearSum - 1;
        }
        if (daySum < 0) {
            monthSum = monthSum - 1;
            daySum = 31 + daySum;
        }
        return "years:" + Math.abs(yearSum) + ", months:" + Math.abs(monthSum) + ", days:" + Math.abs(daySum);
    }
}
