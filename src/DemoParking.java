public class DemoParking {
    public static void main(String[] args) {

        System.out.println("===== 🚗 START PARKING DEMO =====");

        // 1. Создаю автомобили
        CarPerson car1 = new CarPerson(
                "BMW", VehicleState.NEW, VehicleSize.SUV, "AA1234", "X5",
                "Влад",
                null, null, null,
                false, null, null, false
        );

        CarPerson car2 = new CarPerson(
                "Audi", VehicleState.NEW, VehicleSize.CAR, "BB5678", "A4",
                "Катя",
                null, null, null,
                false, null, null, false
        );

        CarPerson car3 = new CarPerson(
                "Volvo", VehicleState.NEW, VehicleSize.TRUCK, "CC9012", "FH16",
                "Николай",
                null, null, null,
                false, null, null, false
        );

        // 2. Регистрация
        System.out.println("\n--- 🅿 РЕГИСТРАЦИЯ ---");
        car1.registration(ParkingManager.assignPlace(car1.getSize()));
        car2.registration(ParkingManager.assignPlace(car2.getSize()));
        car3.registration(ParkingManager.assignPlace(car3.getSize()));

        // 3. Поточный статус
        ParkingManager.printStatus();

        // 4. Оплата
        System.out.println("\n--- 💳 ОПЛАТА ---");
        car1.isPayment("card");
        car2.isPayment("applepay");
        car3.isPayment("cash");

        // 5. После оплаты места должны освободиться
        System.out.println("\n--- 🚪 ВЫЕЗД (места освобождаются) ---");
        System.out.println("Машина " + car1.getName() + " місце → " + car1.getParkingPlace());
        System.out.println("Машина " + car2.getName() + " місце → " + car2.getParkingPlace());
        System.out.println("Машина " + car3.getName() + " місце → " + car3.getParkingPlace());

        // 6. Показываем финальный статус
        ParkingManager.printStatus();

        System.out.println("===== 🏁 END PARKING DEMO =====");
    }
}
