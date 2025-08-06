package LowLevelDesign.BookMyShow;

import LowLevelDesign.BookMyShow.Enums.CityName;
import LowLevelDesign.BookMyShow.Enums.TheaterName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Theater {
    TheaterName theaterName;
    String address;
    CityName cityName;
    int screens;
    List<Show> showList;
    HashMap<String,List<Show>> movieToShowsMap;
    HashMap<Integer,List<int[]>> screenToStartAndEndTimeList;

    public Theater(TheaterName theaterName, String address, CityName cityName){
        this.theaterName = theaterName;
        this.address = address;
        this.cityName = cityName;
        this.screens = 0;
        this.showList = new ArrayList<>();
        this.movieToShowsMap = new HashMap<>();
        this.screenToStartAndEndTimeList = new HashMap<>();
    }

    public void addScreens(int screenCount){
        for(int i=screens;i<screens+screenCount;i++){
            List<int[]> showStartEndTime = new ArrayList<>();
            screenToStartAndEndTimeList.put(i,showStartEndTime);
        }
        screens += screenCount;
    }
}
