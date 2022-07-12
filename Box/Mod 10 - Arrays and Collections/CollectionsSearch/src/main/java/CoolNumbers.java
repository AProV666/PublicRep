import java.util.*;

public class CoolNumbers {

    public static List<String> generateCoolNumbers() {

        List<String> coolNum = new ArrayList<>();
        Random strRandom = new Random();
        char[] strAlphabet = "АВЕКМНОРСТУХ".toCharArray();
        int strLength = strAlphabet.length;

        String str = "";

        for (int i = 0; i < 2_000_000; i++) {
            char r1 = strAlphabet[strRandom.nextInt(strLength)];
            int n1 = (int) Math.floor(Math.random() * 10);
            int n2 = (int) Math.floor(Math.random() * 10);
            int n3 = (int) Math.floor(Math.random() * 10);
            char r2 = strAlphabet[strRandom.nextInt(strLength)];
            char r3 = strAlphabet[strRandom.nextInt(strLength)];
            int n4 = (int) (1 + Math.floor(Math.random() * 199));
            String strReg = "";
            if (n4 < 10 && n4 > 0) {
                strReg = "0" + n4;
            } else {
                strReg = String.valueOf(n4);
            }
            str = String.valueOf(r1 + "" + n1 + "" + n2 + "" + n3 + "" + r2 + "" + r3 + "" + strReg);

            coolNum.add(str);
        }
        return coolNum;
    }


    public static boolean bruteForceSearchInList(List<String> list, String number) {
        String str = "";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(number)) {
                str = list.get(i);
            }
        }

        return str.equals(number) ? true : false;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        Collections.sort(sortedList);
        String str = "";
        for (int i = 0; i < sortedList.size(); i++) {
            if (sortedList.get(i).equals(number)) {
                str = sortedList.get(i);
            }
        }
        return str.equals(number) ? true : false;
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        String str = "";
        for (String word : hashSet) {
            if (word.equals(number)) {
                str = word;
            }

        }
        return str.equals(number) ? true : false;
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        String str = "";
        for (String word : treeSet) {
            if (word.equals(number)) {
                str = word;
            }

        }
        return str.equals(number) ? true : false;
    }
}

