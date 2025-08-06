package LowLevelDesign.BookMyShow;

import LowLevelDesign.BookMyShow.Enums.CityName;
import LowLevelDesign.BookMyShow.Enums.Genre;
import LowLevelDesign.BookMyShow.Enums.Language;
import LowLevelDesign.BookMyShow.Enums.TheaterName;

import java.util.Date;
import java.util.HashMap;

public class AdminPortal {
    HashMap<CityName,City> cityMap;

    public AdminPortal(){
        this.cityMap = new HashMap<>();
    }

    public Movie createAndAddMovie(String movieName, Language language, Genre genre){
        return new Movie(movieName, language, genre);
    }

    public void addCity(CityName cityName){
        if(cityMap.containsKey(cityName)) {
            cityMap.get(cityName);
            return;
        }
        City city = new City(cityName);
        cityMap.put(cityName,city);
    }

    public Theater addTheater(TheaterName theaterName, String address, CityName cityName){
        City city = cityMap.getOrDefault(cityName, null);
        if(city == null){
            System.out.println("No city is present with this name");
        }
        Theater theater = city.theaterMap.get(theaterName);
        if(theater == null)
            theater = new Theater(theaterName, address, cityName);
        return theater;
    }

    public Show addShow(String showId, String movieName, CityName cityName, TheaterName theaterName,
                        int screenId, Date startTime, Date endTime){
        return new Show(showId, movieName, cityName, theaterName, screenId, startTime, endTime);
    }
}
