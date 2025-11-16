import java.util.*;

/**
 * ParkingManager - класс который помагает из парковкой
 * TOTAL_NUMBER_OF_PLACES - Количество парковочных мест:
 * 10 місць - TRUCK
 * 30 місць - SUV
 * 50 місць - CAR
 * 10 місць - MOTORBIKE
 * List<Integer> freePlaces - список свободных мест на парковке
 * List<Integer> reservedPlaces - список зарезервированных мест на парковке
 * Map<Integer, VehicleSize> placeToSizeMap - карта парковочных мест под тип авто
 */
public class ParkingManager {
    private static final int TOTAL_NUMBER_OF_PLACES = 100;
    private static List<Integer> freePlaces = new ArrayList<>();
    private static List<Integer> reservedPlaces = new ArrayList<>();
    private static Map<Integer, VehicleSize> placeToSizeMap = new HashMap<>();

    // инициализация парковочных мест
    static {
        int index = 1;

        // 10 places for TRUCK
        for (int i = 0; i < 10; i++) {
            placeToSizeMap.put(index, VehicleSize.TRUCK);
            freePlaces.add(index);
            index++;
        }

        // 30 places for SUV
        for (int i = 0; i < 30; i++) {
            placeToSizeMap.put(index, VehicleSize.SUV);
            freePlaces.add(index);
            index++;
        }

        // 50 places for CAR
        for (int i = 0; i < 50; i++) {
            placeToSizeMap.put(index, VehicleSize.CAR);
            freePlaces.add(index);
            index++;
        }

        // 10 places for MOTORBIKE
        for (int i = 0; i < 10; i++) {
            placeToSizeMap.put(index, VehicleSize.MOTORBIKE);
            freePlaces.add(index);
            index++;
        }
    }

    // метод выдачи парковочного места
    public static int assignPlace(VehicleSize size) {
        for (Integer place : freePlaces) {
            VehicleSize placeType = placeToSizeMap.get(place);
            if (placeType == size) {
                freePlaces.remove(place);
                reservedPlaces.add(place);
                return place;
            }
        }
        return -1;
    }

    // возврат места при выезде авто с парковки
    public static void freePlace(int placeNumber) {
        if (!reservedPlaces.contains(placeNumber)) {
            System.out.println("⚠️ Место " + placeNumber + " не является занятым.");
            return;
        }
        reservedPlaces.remove(Integer.valueOf(placeNumber));
        freePlaces.add(placeNumber);
        Collections.sort(freePlaces);
        System.out.println("🟢 Место " + placeNumber + " успешно освобождено.");
    }

    // метод  админ панель (карта парковки м парковочных мест)
    public static void printStatus() {
        System.out.println("\n===== 📊 СТАТУС ПАРКИНГА =====");

        int total = placeToSizeMap.size();
        int free = freePlaces.size();
        int reserved = reservedPlaces.size();

        System.out.println("Всего мест: " + total);
        System.out.println("Свободно:  " + free);
        System.out.println("Занято:    " + reserved);

        System.out.println("\n--- Детализация по типам ---");

        // Подсчет по VehicleSize
        for (VehicleSize size : VehicleSize.values()) {

            long totalByType = placeToSizeMap.values().stream()
                    .filter(v -> v == size)
                    .count();

            long freeByType = freePlaces.stream()
                    .filter(place -> placeToSizeMap.get(place) == size)
                    .count();

            long reservedByType = totalByType - freeByType;

            System.out.println(size + ":");
            System.out.println("  всего:    " + totalByType);
            System.out.println("  свободно: " + freeByType);
            System.out.println("  занято:   " + reservedByType);
            System.out.println();
        }

        System.out.println("=================================\n");
    }

}