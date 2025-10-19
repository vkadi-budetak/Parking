import java.util.List;

// Interface - Разпределяет автомобили по этажам
public interface FloorHelferable {

    void helpWithFloor(Integer numberFloor); // помощник разпределений по этажам

    List<Integer> getExpertFloor();
}
