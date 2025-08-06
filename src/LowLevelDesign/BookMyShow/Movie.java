package LowLevelDesign.BookMyShow;

import LowLevelDesign.BookMyShow.Enums.Genre;
import LowLevelDesign.BookMyShow.Enums.Language;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Movie {
    String name;
    Language language;
    Genre genre;
}
