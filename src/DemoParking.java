
public class DemoParking {
    public static void main(String[] args) {

        // Перевіряєм реєстрацію
        CarPerson car1 = new CarPerson("BMW", "X5", "AA1234", VehicleSize.SUV, "Влад");
        car1.registration(2);


        System.out.println("📋 Все зарегистрированные места: " + car1.getListCarOnParking());

        // Pay
        car1.isPayment("card");
        car1.isPayment("Bitcoin");

    }
}