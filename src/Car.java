import java.util.List;

public class Car extends TransportVehicle implements Registrationable{

    public Car(String brand, int carNumber) {
        super(brand, carNumber);
    }

    @Override
    public void Registration(Integer parkingNumber) {

    }

    @Override
    public List<Integer> getListCarOnParking() {
        return List.of();
    }

    @Override
    public String introduce() {
        return "";
    }
}
