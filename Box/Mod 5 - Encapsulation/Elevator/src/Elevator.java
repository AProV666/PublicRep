public class Elevator {
    private int currentFloor = 1;
    private final int minFloor;
    private final int maxFloor;

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveDown() {
        currentFloor = currentFloor > minFloor ? currentFloor - 1 : currentFloor;
    }

    public void moveUp() {
        currentFloor = currentFloor < maxFloor ? currentFloor + 1 : currentFloor;
    }

    public void move(int floor) {
        if (floor >= minFloor && floor <= maxFloor) {
            if (floor > currentFloor) {
                for (int i = currentFloor; i < floor; i++) {
                    moveUp();
                    System.out.println(getCurrentFloor());
                }
            } else if (floor < currentFloor) {
                for (int i = currentFloor; i > floor; i--) {
                    moveDown();
                    System.out.println(getCurrentFloor());
                }
            } else if (floor == currentFloor) {
                System.out.println();
            }
        } else {
            System.out.println("Введен неверный номер этажа!");
        }
    }
}
