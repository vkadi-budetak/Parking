/**
 * Create a class Transport vehicle
 * */

public abstract class TransportVehicle implements Comparable<TransportVehicle> {
    protected String brand; // brand Car
    protected int carNumber; // Number Car

    // Constructor
    public TransportVehicle(String brand, int carNumber) {
        this.brand = brand;
        this.carNumber = carNumber;
    }

    //Getter
    public String getBrand() {
        return brand;
    }

    public int getCarNumber() {
        return carNumber;
    }

    // Car greetings
    public abstract String introduce ();

    // information about a person
    public void showCarInfo(){
        System.out.println("\uD83D\uDE97 Car model: " + brand + "License plate number: " +
                carNumber);
    }

    @Override
    public int compareTo(TransportVehicle other) {
        return this.brand.compareTo(other.brand);
    }

    @Override
    public String toString() {
        return "TransportVehicle{" +
                "brand='" + brand + '\'' +
                ", carNumber=" + carNumber +
                '}';
    }
}
