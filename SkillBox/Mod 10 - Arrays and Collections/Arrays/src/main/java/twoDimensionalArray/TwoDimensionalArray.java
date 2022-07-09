package twoDimensionalArray;

public class TwoDimensionalArray {

    public static final char SYMBOL = 'X';
    public static final char SPACE = ' ';

    public static char[][] getTwoDimensionalArray(int size) {

        char[][] array = new char[size][size];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j || i == array.length - j - 1) {
                    array[i][j] = SYMBOL;
                } else {
                    array[i][j] = SPACE;
                }
            }
        }
        return array;
    }
}
