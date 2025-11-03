import java.util.List;

/**
 * Registrationable - Реестрация автомобиля
 * registration - метод реестрация автомобиля в определенное время приезда и присвоения id
 * getListCarOnParking - List сохраняем список зарегестрированных атомобилей
 */
public interface Registrationable {

    void registration(Integer parkingNumber);
    List<Integer> getListCarOnParking();
}