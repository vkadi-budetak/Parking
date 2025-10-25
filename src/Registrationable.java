import java.util.List;

// Interface - Реестрация автомобиля
public interface Registrationable {

    void Registration(Integer parkingNumber); // При реестрации получает свой парк номер

    List<Integer> getListCarOnParking(); //List сохраняем список зарегестрированных атомобилей

}