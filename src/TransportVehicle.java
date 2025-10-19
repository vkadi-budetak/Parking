/**
 * Create a class Transport vehicle
 * sedan, hatchback, station wagon, coupe, crossover, SUV
 * */

public abstract class TransportVehicle implements Comparable<TransportVehicle> {
    protected String brand; // brand Car
    protected String type; // type Car
    protected int carNumber; // Number Car

    // Constructor
    public TransportVehicle(String brand, String type, int carNumber) {
        this.brand = brand;
        this.type = type;
        this.carNumber = carNumber;
    }

    //Геттеры
    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public int getCarNumber() {
        return carNumber;
    }


    // Метод -> Приветсвие для человека
    public abstract String introduce ();


    // Информационный метод -> Модель + тип автомобиля + номер авто +
    public void showCarInfo(){
        System.out.println("\uD83D\uDE97 Car model: " + brand + " - " + type + ", " +
                "License plate number: " + carNumber);
    }

    //Будем делать фильтр по типу автомобиля
    @Override
    public int compareTo(TransportVehicle other) {
        return this.type.compareTo(other.type);
    }

    @Override
    public String toString() {
        return "TransportVehicle{" +
                "brand = '" + brand + '\'' +
                ", type = '" + type + '\'' +
                ", carNumber = " + carNumber +
                '}';
    }
}
