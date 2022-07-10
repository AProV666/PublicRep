import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь до папки: ");
        String path = scanner.nextLine();
        long sizeFiles = FileUtils.calculateFolderSize(path);
        String str = getReadableSize(sizeFiles);

        System.out.println("Размер папки " + path + " cоставляет " + str);
    }

    public static String getReadableSize(long size) {
        char[] sizeMultipliers = {'б', 'К', 'М', 'Г', 'Т'};
        for (int i = 0; i < sizeMultipliers.length; i++) {
            double value = size / Math.pow(1024, i);
            if (value < 1024) {
                return (String.format("%.2f", value)) + " " + sizeMultipliers[i] + (i > 0 ? "б" : "");
            }
        }
        return "So big";
    }
}
