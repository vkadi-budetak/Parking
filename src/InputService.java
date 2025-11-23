import java.util.Scanner;

/**
 * InputService - класс создания и регистрации автомобиля из консоли
 */
public class InputService {
    private final Scanner scanner = new Scanner(System.in);


    // Конструктор от CarPerson
    public CarPerson createCarFromConsole() {
        System.out.println("\n🚗 --- ВЪЕЗД НА ПАРКОВКУ ---");

        System.out.print("👤 Введите ваше имя: ");
        String name = scanner.nextLine();

        System.out.print("🏎 Марка автомобиля (например: BMW, Audi): ");
        String brand = scanner.nextLine();

        System.out.print("📘 Тип кузова (например: sedan, suv): ");
        String type = scanner.nextLine();

        System.out.print("🔖 Номер авто: ");
        String carNumber = scanner.nextLine();

        VehicleSize size = null;
        while (size == null) {
            System.out.print("📏 Размер авто (MOTORBIKE, CAR, SUV, TRUCK): ");
            String sizeInput = scanner.nextLine().toUpperCase().trim();
            try {
                size = VehicleSize.valueOf(sizeInput);
            } catch (IllegalArgumentException e) {
                System.out.println("❌ Ошибка! Такого типа нет. Попробуйте еще раз.");
            }
        }

        // Создаем обьет
        CarPerson car = new CarPerson(brand, type, carNumber, size, name);

        System.out.println("---------------------------------");
        car.showCarInfo();
        System.out.println("---------------------------------");

        return car;
    }

}
