public class TrucksContainersAndBoxes {

    final int CONTAINERS_IN_TRUCK = 12;
    final int BOXES_IN_CONTAINER = 27;
    final int BOXES_IN_TRUCK = CONTAINERS_IN_TRUCK * BOXES_IN_CONTAINER;

    int trucks;
    int containers;
    int boxes;

    public TrucksContainersAndBoxes(int boxes) {
        this.boxes = boxes;
    }

    public void trucksAndContainers() {
        containers = boxes / BOXES_IN_CONTAINER;
        containers = boxes % BOXES_IN_CONTAINER == 0 ? containers : containers + 1;
        trucks = containers / CONTAINERS_IN_TRUCK;
        trucks = containers % CONTAINERS_IN_TRUCK == 0 ? trucks : trucks + 1;

        int num1 = 1;
        int num1_1 = 1;
        int num2 = 1;
        int num2_2 = 1;
        int num3 = 1;
        int num3_3 = 1;

        for (int i = 1; i <= boxes; i++) {
            if (i == num1) {
                System.out.println("Грузовик: " + num1_1);
                num1 += (BOXES_IN_TRUCK);
                num1_1 = num1_1 + 1;
            }
            if (num2_2 % (CONTAINERS_IN_TRUCK + 1) == 0) {
                num2_2 = 1;
            }
            if (i == num2) {
                System.out.println("\t" + "Контейнер: " + num2_2);
                num2 += (BOXES_IN_CONTAINER);
                num2_2 = num2_2 + 1;
            }

            if (num3_3 % (BOXES_IN_CONTAINER + 1) == 0) {
                num3_3 = 1;
            }
            if (i == num3) {
                System.out.println("\t" + "\t" + "Ящик: " + num3_3);
                num3 += 1;
                num3_3 = num3_3 + 1;
            }
        }
    }

    @Override
    public String toString() {
        return "\n" + "Необходимо: " + "\n"
                + "\t" + "Грузовиков - " + trucks + " шт." + "\n"
                + "\t" + "Контейнеров - " + containers + " шт.";
    }
}
