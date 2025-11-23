import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Класс CarPerson - создаю автомобиль наследусь от TransportVehicle и имплементирую интерфейсы
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
public class CarPerson extends TransportVehicle implements Registrationable, Paymentsable, FloorHelferable, TicketPrintable, Exitable {
    private String name;
    private LocalDateTime timeEntry;
    private LocalDateTime timeDeparture;
    private Duration timeParking;
    private boolean paid;
    private String ticketId;
    private Integer parkingPlace;
    private boolean parked;

    // Короткий конструктор
    public CarPerson(String brand, String type, String carNumber, VehicleSize size, String name) {
        super(brand, VehicleState.NEW, size, carNumber, type);
        this.name = name;
        this.parked = false;
    }

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
        List<String> payList = List.of("cash", "card", "applepay", "googlepay");

        String method = meaning.toLowerCase();

        if (payList.contains(method)) {
            paid = true;
            System.out.println("💳 Выбран способ оплаты: " + method);
            System.out.println("✅ Оплата успешна!");

            // Расчет стоимости парковки
            return calculatingParkingCosts();
        } else {
            paid = false;
            System.out.println("💳 Выбран способ оплаты: " + meaning);
            System.out.println("❌ Неизвестный способ оплаты. Попробуйте другой..");
            return false;
        }
    }

    private boolean calculatingParkingCosts() {
        timeDeparture = LocalDateTime.now();

        timeParking = Duration.between(timeEntry, timeDeparture);

        // Округляем минуты до часов
        long minutes = timeParking.toMinutes();
        long hours = (long) Math.ceil(minutes / 60.0);

        double rate = this.size.getRatePerHour();
        double price = hours * rate;

        System.out.println("⏱ Время стоянки: " + minutes + " минут (" + hours + " часа)");
        System.out.println("💸 Стоимость: " + price + " €");
        System.out.println("🕒 Время выезда: " + timeDeparture);

        state = VehicleState.LEFT;
        parked = false;
        ParkingManager.freePlace(parkingPlace);

        return true;
    }

    @Override
    public void registration(Integer parkingNumber) {
        System.out.println("Регистрация для " + name);
        System.out.println("Ваш автомобиль - " + brand + ", " + type);
        System.out.println("Номер автомобиля - " + carNumber);

        // Если авто незарегистрированое
        if (!parked) {
            // фиксируем время вьезда
            timeEntry = LocalDateTime.now();
            // Присваеваем парковочное место
            parkingPlace = parkingNumber;
            System.out.println(getName() + " Ваше парковочное место - " + parkingPlace);

            ticketId = UUID.randomUUID().toString().substring(0, 8); // создаем уникальный короткий ID код для каждого автомобиля

            parked = true;
            state = VehicleState.PARKED;

            // Вызываем метод интерфейса
            printParkingTicket();

        } else {
            System.out.println("⚠️ Автомобиль уже зарегистрирован!");
        }
    }

    @Override
    public String introduce() {
        return "";
    }

    @Override
    public void printParkingTicket() {
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = timeEntry.format(formatter);

        System.out.println("\n=======================================");
        System.out.println("      🅿️  PARKING TICKET  🅿️      ");
        System.out.println("=======================================");
        System.out.println("🎫 ID билета:  " + ticketId);
        System.out.println("📍 Место №:    " + parkingPlace + " (" + size + ")");
        System.out.println("📆 Час в'їзду: " + formattedDate);
        System.out.println("🚘 Авто:       " + brand + " " + type + " (" + carNumber + ")");
        System.out.println("👤 Владелец:    " + name);
        System.out.println("💰 Тариф:      " + size.getRatePerHour() + " €/час");
        System.out.println("=======================================");
        System.out.println("✅ Шлагбаум открыт. Хорошего дня!\n");
    }

    @Override
    public void leaveParking(int hoursStayed) {
        if (!parked) {
            System.out.println("⚠️ Эта машина не на парковке!");
            return;
        }

        // 1. Симулируем время
        this.timeDeparture = this.timeEntry.plusHours(hoursStayed);

        // 2. Рассчитываем цену
        double price = hoursStayed * size.getRatePerHour();

        // 3. Выводим чек
        System.out.println("\n💳 --- СЧЕТ ЗА ПАРКОВКУ ---");
        System.out.println("Время стоянки: " + hoursStayed + " час.");
        System.out.println("Тариф:       " + size.getRatePerHour() + " €/час");
        System.out.println("К ОПЛАТЕ:   " + price + " €");
        System.out.println("--------------------------------");

        // 4. Оплата
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        boolean paymentSuccess = false;

        while (!paymentSuccess) {
            System.out.print("Выберите способ оплаты (cash, card, applepay): ");
            String method = scanner.nextLine();

            // Используем собственный метод из интерфейса Paymentsable
            paymentSuccess = isPayment(method);

            if (!paymentSuccess) {
                System.out.println("❌ Оплата не прошла.");
            }
        }

        // 5. Завершаем выезд - открываем шлагбаум
        completeExit(price);
    }

    private void completeExit(double finalPrice) {
        ParkingManager.freePlace(this.parkingPlace);
        this.parked = false;
        this.state = VehicleState.LEFT;

        System.out.println("\n🚗 Шлагбаум открыт! Счастливого пути, " + name + "!");
        System.out.println("Сплачено: " + finalPrice + " €");
    }
}
