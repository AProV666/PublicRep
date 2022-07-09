public class Main {

    public static void main(String[] args) {
        Country country = new Country("USA");

        System.out.println(country.getName());

        country.setArea(9834000);
        System.out.println(country.getArea());

        country.setPopulation(329500000);
        System.out.println(country.getPopulation());

        country.setCapital("Washington DC");
        System.out.println(country.getCapital());

        country.setAccessToTheSea(false);
        System.out.println(country.isAccessToTheSea());


        Car car = new Car("Tesla", "Model S");

        System.out.println(car.getBrand() + " " + car.getModel());

        car.setMaxSpeed(249);
        System.out.println(car.getMaxSpeed());

        car.setColor("White");
        System.out.println(car.getColor());

        car.setElectric(true);
        System.out.println(car.isElectric());


    }
}
