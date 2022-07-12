package strings;

public class TotalEarningsCalculator {

    public static void main(String[] args) {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        String charsetStr1 = "Вася заработал ";
        String charsetStr2 = "Петя - ";
        String charsetStr3 = "Маша - ";

        String str1 = getEncoding(text, charsetStr1);
        String str2 = getEncoding(text, charsetStr2);
        String str3 = getEncoding(text, charsetStr3);

        int count1 = Integer.parseInt(str1);
        int count2 = Integer.parseInt(str2);
        int count3 = Integer.parseInt(str3);

        int sum = count1 + count2 + count3;
        System.out.println(sum);
    }

    public static String getEncoding(String text, String charsetStr) {
        int start = text.indexOf(charsetStr);
        int end = text.indexOf(" р", start);
        if (start < 0 || end < 0) {
            return "";
        }
        String encoding = text.substring(start + charsetStr.length(), end);
        return encoding;
    }
}


