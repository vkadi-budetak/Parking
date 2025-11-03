import java.util.List;
/**
 * Interface - FloorHelferable - Ищит свободное место на этаже и присваетва парковочное место автомобилю
 * helpWithFloor(numParking - номер парковки) - метод по поиску и присвоения парковочного места на этаже
 * getListOfParkingPlace(floor - этаж, typeCar - тип автомобиля(от габаритности авто
 * будет зависить этаж)) - список всех пустых парковочныч мест на этажах.
 * getListReservedParkingPlace - список занятых парковочных мест
 */
public interface FloorHelferable {

    void helpWithParkPlace(Integer carId);

    List<Integer> getListOfParkingPlace(Integer floor, String typeCar);
    List<Integer> getListReservedParkingPlace();
}
