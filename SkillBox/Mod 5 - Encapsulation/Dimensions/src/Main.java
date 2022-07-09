public class Main {

    public static void main(String[] args) {

        Dimensions dimensions = new Dimensions(1, 2, 3);
        Information information = new Information(dimensions, 100, "Moscow", false, "66ndf789", true);
        System.out.println(information);

        System.out.println(information.setDimensions(dimensions.setHeight(6)));

        System.out.println(information.setDeliveryAddress("St. Petersburg"));

        System.out.println(information.setWeight(666));

    }
}
