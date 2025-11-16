/**
 * Размер автомобиля
 *     ratePerHour - цена за парковку в час:
 *      - MOTORBIKE(1.0) - 1 € в час
 *      - CAR(2.0) - 2 € в час
 *      - SUV(3.5) - 3,5 € в час
 *      - TRUCK(5.0) - 5 € в час
 */
public enum VehicleSize {
    MOTORBIKE(1.0),
    CAR(2.0),
    SUV(3.5),
    TRUCK(5.0);

    private final double ratePerHour;

    // Конструктор
    VehicleSize(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    // Геттеры
    public double getRatePerHour() {
        return ratePerHour;
    }
}
