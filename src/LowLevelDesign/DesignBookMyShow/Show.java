package LowLevelDesign.DesignBookMyShow;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
public class Show {
    int id;
    Movie movie;
    Screen screen;
    int startTime;
    List<Integer> bookedSeatIds;

    Show(int id, Movie movie, Screen screen, int startTime){
        this.id = id;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
    }
}
