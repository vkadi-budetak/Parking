import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Car extends TransportVehicle implements Registrationable, TicketPrinterable, Paymentsable{
    private String name; // Владелец авто
    private double timeParking; // сколько времени нужно парковатся
    private Set<Integer> FloorPlace; // поверх парковки

    // Конструктор
    public Car(String brand, String type, int carNumber, String name, double timeParking) {
        super(brand, type, carNumber);
        this.name = name;
        this.timeParking = timeParking;
        this.FloorPlace = new HashSet<>(); // уникальное парковочное место на этаже
    }

    // Геттеры
    public String getName() {
        return name;
    }
    public double getTimeParking() {
        return timeParking;
    }
    public Set<Integer> getFloorPlace() {
        return FloorPlace;
    }

    @Override
    public boolean isPayment(String meaning) {
        return false;
    }

    @Override
    public void Registration(Integer parkingNumber) {

    }

    @Override
    public List<Integer> getListCarOnParking() {
        return List.of();
    }

    @Override
    public void ticketPrint(String ticket) {

    }

    @Override
    public boolean isPresenceOf(String place) {
        return false;
    }

    @Override
    public String introduce() {
        return "Hey, " + this.name + " your \\uD83D\\uDE97 is - " +
                this.brand + "(\\uD83D\\uDD22 " + this.carNumber + ")";
    }
}
