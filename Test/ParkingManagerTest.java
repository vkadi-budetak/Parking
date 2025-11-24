import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingManagerTest {

    @Test
    void assignPlace() {
        VehicleSize truck = VehicleSize.TRUCK;
        int actualPlace = ParkingManager.assignPlace(truck);
        assertEquals(1, actualPlace, "Для первого грузовика должно быть место №1");
    }

    @Test
    void freePlace() {
    }

    @Test
    void printStatus() {
    }
}