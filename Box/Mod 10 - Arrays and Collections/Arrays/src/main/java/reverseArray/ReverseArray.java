package reverseArray;

public class ReverseArray {

    public static String[] reverse(String[] strings) {
        String[] copy = new String[strings.length];

        for (int i = 0; i < strings.length; i++) {
            copy[i] = strings[strings.length - 1 - i];
        }
        for (int i = 0; i < strings.length; i++) {
            strings[i] = copy[i];
        }
        return strings;
    }
}