/**
 * Transport vehicle - класс транспортного средтства
 *     brand - бренд авто
 *     type - модель авто
 *     carNumber - номер авто
 *     size - тип авто ()
 *     state - NEW, PARKED, LEFT (Новый автомобиль/припаркованный/Выехал)
 *
 * */

public abstract class TransportVehicle implements Comparable<TransportVehicle> {
    protected String brand;
    protected String type;
    protected String carNumber;
    protected VehicleSize size;
    protected VehicleState state;

    // Constructor
    public TransportVehicle(String brand, VehicleState state, VehicleSize size, String carNumber, String type) {
        this.setBrand(brand);
        this.setType(type);
        this.setCarNumber(carNumber);
        this.setSize(size);
        this.state = VehicleState.NEW;
    }

    //Геттеры
    public String getBrand() {
        return brand;
    }
    public String getType() {
        return type;
    }
    public String getCarNumber() {
        return carNumber;
    }
    public VehicleSize getSize() {
        return size;
    }
    public VehicleState getState() {
        return state;
    }

    public void setBrand(String brand) {
        if (brand != null) this.brand = brand;
        else System.out.println("brand is not correct");
    }
    public void setType(String type) {
        if (type != null) this.type = type;
        else System.out.println("type is not correct");
    }
    public void setCarNumber(String carNumber) {
        if (carNumber != null ) this.carNumber = carNumber;
    else System.out.println("carNumber is not correct");
    }
    public void setSize(VehicleSize size) {
        if (size != null) this.size = size;
        else System.out.println("carNumber is not correct");
    }

    // Метод -> Приветсвие для человека
    public abstract String introduce ();

    // Информационный метод -> Модель + тип автомобиля + номер авто
    public void showCarInfo(){
        System.out.println("\uD83D\uDE97 " + brand + " " + type + " | plate= " +
                 carNumber + " | size=" + size +
                " | state=" + state);
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
