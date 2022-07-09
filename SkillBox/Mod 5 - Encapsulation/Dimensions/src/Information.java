public class Information {

    private final Dimensions dimensions;
    private final double weight;
    private final String deliveryAddress;
    private final boolean isInvertible;
    private final String registrationNumber;
    private final boolean isFragile;

    public Information(Dimensions dimensions, double weight, String deliveryAddress, boolean isInvertible, String registrationNumber, boolean isFragile) {
        this.dimensions = dimensions;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.isInvertible = isInvertible;
        this.registrationNumber = registrationNumber;
        this.isFragile = isFragile;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public double getWeight() {
        return weight;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public boolean isInvertible() {
        return isInvertible;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public boolean isFragile() {
        return isFragile;
    }

    public Information setDimensions(Dimensions dimensions) {
        return new Information(dimensions, weight, deliveryAddress, isInvertible, registrationNumber, isFragile);
    }

    public Information setDeliveryAddress(String deliveryAddress) {
        return new Information(dimensions, weight, deliveryAddress, isInvertible, registrationNumber, isFragile);
    }

    public Information setWeight(double weight) {
        return new Information(dimensions, weight, deliveryAddress, isInvertible, registrationNumber, isFragile);
    }

    public String toString() {
        return "Параметры заказа:" + "\n" + dimensions + "\n" + "Вес: " + weight + " кг" + "\n" + "Адрес доставки: " + deliveryAddress + "\n" + "Регистрационный номер: " + registrationNumber;
    }
}
