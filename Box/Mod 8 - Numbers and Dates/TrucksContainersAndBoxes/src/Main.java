import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int boxes = scanner.nextInt();

        TrucksContainersAndBoxes trucksContainersAndBoxes = new TrucksContainersAndBoxes(boxes);
        trucksContainersAndBoxes.trucksAndContainers();
        System.out.println(trucksContainersAndBoxes);
    }
}