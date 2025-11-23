import java.util.Scanner;

public class DemoParking {
    public static void main(String[] args) {
        System.out.println("===== 🚗 START PARKING DEMO =====");

        // 1. Въезд
        InputService inputService = new InputService();
        CarPerson car = inputService.createCarFromConsole();

        System.out.println("🔎 Система ищет свободное место...");
        int place = ParkingManager.assignPlace(car.getSize());

        if (place != -1) {
            car.registration(place);

            // --- СИМУЛЯЦИЯ ЖИЗНИ ---
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n⏳ Машина стоит на парковке...");
            System.out.print("⌨️  Введите, сколько часов прошло (например, 2 или 5): ");

            int hours = scanner.nextInt(); // Читаем число

            // 2. Выезд
            car.leaveParking(hours);

            // 3. Проверка статуса парковки после выезда
            ParkingManager.printStatus();

        } else {
            System.out.println("🔴 Мест нет!");
        }

        System.out.println("===== 🏁 END PARKING DEMO =====");
    }
}