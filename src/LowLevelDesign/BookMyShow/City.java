package LowLevelDesign.BookMyShow;

import LowLevelDesign.BookMyShow.Enums.CityName;
import LowLevelDesign.BookMyShow.Enums.TheaterName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class City {
    CityName cityName;
    List<Movie> movieList;
    HashMap<TheaterName, Theater> theaterMap;
    HashMap<String,List<Theater>> movieToTheaterList;

    public City(CityName cityName){
        this.cityName = cityName;
        this.movieList = new ArrayList<>();
        this.theaterMap = new HashMap<>();
        this.movieToTheaterList = new HashMap<>();
    }
}
