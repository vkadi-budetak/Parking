import java.util.List;

// Interface - Car registration at the entrance
public interface Registrationable {

    void Registration(Integer parkingNumber); // parking space number

    //List збергіє список автомобілів
    List<Integer> getListCarOnParking();
}
