//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//public class Car extends TransportVehicle implements Registrationable, TicketPrinterable, Paymentsable{
//    private String name; // Владелец авто
//    private double timeParking; // сколько времени нужно парковатся
//    private List<Integer> floorPlace; // этаж парковки
//    private Set<Integer> parkingPlace; // номер парковки
//    private List<Integer> listCarOnParking; // лист зарегистрированых автомобилей
//
//    // Конструктор
//
//    public Car(String brand, String type, int carNumber, String name, double timeParking, Set<Integer> floorPlace, Set<Integer> parkingPlace) {
//        super(brand, type, carNumber);
//        this.name = name;
//        this.timeParking = timeParking;
//        this.floorPlace = new ArrayList<>(); // уникальное парковочное место на каком этаже
//        this.parkingPlace = new HashSet<>(); //  уникальное парковочное место
//        this.listCarOnParking = new ArrayList<>(); // лист зарегистрированых автомобилей
//    }
//
//    // Геттеры
//
//    public String getName() {
//        return name;
//    }
//    public double getTimeParking() {
//        return timeParking;
//    }
//    public List<Integer> getFloorPlace() {
//        return floorPlace;
//    }
//    public Set<Integer> getParkingPlace() {
//        return parkingPlace;
//    }
//
//
//
//    @Override
//    public boolean isPayment(String meaning) {
//        System.out.println(name);
//        return false;
//    }
//
//    @Override
//    public void registration(Integer parkingNumber) {
//        System.out.println(name + " Зарегистрирован!\n Получите парковочный талон");
//    }
//
//    @Override
//    public List<Integer> getListCarOnParking() { // список зарегистрированых
//        return listCarOnParking;
//    }
//
//    @Override
//    public void ticketPrint(String ticket) {
//        System.out.println("Печатаем билет");
//    }
//
//    @Override
//    public boolean isPresenceOf(String place) {
//        System.out.println("Парковка имеет свободные места");
//        return false;
//    }
//
//    @Override
//    public String introduce() {
//        return "Hey, " + this.name + " your \\uD83D\\uDE97 is - " +
//                this.brand + "(\\uD83D\\uDD22 " + this.carNumber + ")";
//    }
//
//    public void addListCarOnParking(Integer carNumber){
//        System.out.println("Приветсвую в ParkingXXX | \\uD83D\\uDE00 " + name + "\n");
//        showCarInfo();
//        listCarOnParking.add(carNumber);
//    }
//
//    public void removeListCarOnParking(Integer carNumber){
//        System.out.println("Вы покидаете ParkingXXX | \\uD83D\\uDE00 " + name + "\n");
//        showCarInfo();
//        System.out.println("Будем ожижать вас " + name + " снова!");
//        listCarOnParking.remove(carNumber);
//    }
//}
