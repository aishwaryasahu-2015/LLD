package LowLevelDesign.DesignBookMyShow;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class TheaterController {
    Map<City, List<Theater>> cityWiseTheaterList;
    List<Theater> allTheater; //list of all the theaters in the city;

    TheaterController(){
        cityWiseTheaterList = new HashMap<>();
        allTheater = new ArrayList<>();
    }

    void addTheaterInCity(Theater theater, City city){
        allTheater.add(theater);
        List<Theater> theaters = cityWiseTheaterList.getOrDefault(city, new ArrayList<>());
        theaters.add(theater);
        cityWiseTheaterList.put(city,theaters);
    }
}
