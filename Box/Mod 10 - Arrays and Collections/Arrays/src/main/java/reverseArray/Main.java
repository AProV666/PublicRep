package reverseArray;

public class Main {

    public static void main(String[] args) {
        String line = "Каждый охотник желает знать, где сидит фазан";
        String[] array = line.split("[\\s+]");

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        ReverseArray.reverse(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
