package LowLevelDesign.BookMyShow;

import LowLevelDesign.BookMyShow.Enums.CityName;
import LowLevelDesign.BookMyShow.Enums.TheaterName;

import java.util.Date;

public class Show {
    String showId;
    String movieName;
    CityName cityName;
    TheaterName theaterName;
    int screenId;
    Screen screen;
    Date startTime;
    Date endTime;
    //set price based on seats;

    public Show(String showId, String movieName, CityName cityName, TheaterName theaterName, int screenId, Date startTime, Date endTime){
        //check for a particular theater and screenId the slot available if yes then add
        this.showId = showId;
        this.movieName = movieName;
        this.cityName = cityName;
        //update the movie in
    }

    private boolean isShowCanBeAdded(CityName cityName, TheaterName theaterName, int screenId, Date startTime, Date endTime){
      return true;
    }
}
