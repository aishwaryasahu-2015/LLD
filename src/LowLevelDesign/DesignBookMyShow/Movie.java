package LowLevelDesign.DesignBookMyShow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Movie {
    int id;
    String name;
    int duration; //In Minutes
}
