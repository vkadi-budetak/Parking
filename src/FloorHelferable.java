import java.util.List;
/**
 * Interface - FloorHelferable - Ищит свободное место на этаже и присваевает парковочное место автомобилю
 * 1. helpWithFloor(numParking - номер парковки) - метод по поиску и присвоения парковочного места на этаже
 * 2. getListOfParkingPlace(floor - этаж, typeCar - тип автомобиля(от габаритности авто
 * будет зависить этаж)) - метод из список всех пустых парковочныч мест на этажах.
 * 3. getListReservedParkingPlace - метод в котором список занятых парковочных мест.
 */
public interface FloorHelferable {

    void helpWithParkPlace(Integer carId);

    List<Integer> getListOfParkingPlace(Integer floor, String typeCar);
    List<Integer> getListReservedParkingPlace();
}
