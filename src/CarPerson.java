import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Клас CarPerson - создаю автомобиль наследусь от TransportVehicle и имплементирую интерфейсы
 * Registrationable, Paymentsable, FloorHelferable;
 * name - имя владельца авто
 * timeEntry - время приезда
 * timeDeparture - время выезда
 * timeParking -  сколько времени стоит авто на парковке
 * paid - оплата ("cash", "card", "applepay", "googlepay")
 * ticketId - уникальный ID при вьезде
 * parkingPlace - номер парковочного места
 * parked - на парковке да или нет
 */
public class CarPerson extends TransportVehicle implements Registrationable, Paymentsable, FloorHelferable{
    private String name;
    private LocalDateTime timeEntry;
    private LocalDateTime timeDeparture;
    private Duration timeParking;
    private boolean paid;
    private String ticketId;
    private Integer parkingPlace;
    private boolean parked;


    // Конструктор

    public CarPerson(String brand, VehicleState state, VehicleSize size, String carNumber, String type,
                     String name, LocalDateTime timeEntry, LocalDateTime timeDeparture, Duration timeParking,
                     boolean paid, String ticketId, Integer parkingPlace, boolean parked) {
        super(brand, state, size, carNumber, type);
        this.name = name;
        this.timeEntry = timeEntry;
        this.timeDeparture = timeDeparture;
        this.timeParking = timeParking;
        this.paid = paid;
        this.ticketId = ticketId;
        this.parkingPlace = parkingPlace;
        this.parked = parked;
    }


    // Геттеры и сеттеры


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDateTime getTimeEntry() {
        return timeEntry;
    }
    public void setTimeEntry(LocalDateTime timeEntry) {
        this.timeEntry = timeEntry;
    }
    public Duration getTimeParking() {
        return timeParking;
    }
    public void setTimeParking(Duration timeParking) {
        this.timeParking = timeParking;
    }
    public LocalDateTime getTimeDeparture() {
        return timeDeparture;
    }
    public void setTimeDeparture(LocalDateTime timeDeparture) {
        this.timeDeparture = timeDeparture;
    }
    public boolean isPaid() {
        return paid;
    }
    public void setPaid(boolean paid) {
        this.paid = paid;
    }
    public String getTicketId() {
        return ticketId;
    }
    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }
    public Integer getParkingPlace() {
        return parkingPlace;
    }
    public void setParkingPlace(Integer parkingPlace) {
        this.parkingPlace = parkingPlace;
    }
    public boolean isParked() {
        return parked;
    }
    public void setParked(boolean parked) {
        this.parked = parked;
    }

    @Override
    public void helpWithParkPlace(Integer carId) {

    }

    @Override
    public List<Integer> getListOfParkingPlace(Integer floor, String typeCar) {
        return List.of();
    }

    @Override
    public List<Integer> getListReservedParkingPlace() {
        return List.of();
    }

    @Override
    public boolean isPayment(String meaning) {
        return false;
    }

    @Override
    public void registration(Integer parkingNumber) {

    }

    @Override
    public List<Integer> getListCarOnParking() {
        return List.of();
    }

    @Override
    public String introduce() {
        return "";
    }
}
