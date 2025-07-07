package LowLevelDesign.DesignBookMyShow;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Theater {
    int theaterId;
    String address;
    City city;
    List<Screen> screens = new ArrayList<>();
    List<Show> shows = new ArrayList<>();

    //CRUD operation on movies
}
