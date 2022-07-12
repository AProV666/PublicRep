import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите путь папки, которую необходимо скопировать:");
        String sourceDirectory = scanner.nextLine();

        System.out.println("Введите путь, куда необходимо скопировать папку:");
        String destinationDirectory = scanner.nextLine();

        FileUtils.copyFolder(sourceDirectory, destinationDirectory);

    }
}
