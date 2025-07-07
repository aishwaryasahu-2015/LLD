package LowLevelDesign.DesignBookMyShow;

import java.util.*;

public class MovieController {
    Map<City, List<Movie>> cityWiseMovie;
    List<Movie> allMovies;

    MovieController(){
        cityWiseMovie = new HashMap<>();
        allMovies = new ArrayList<>();
    }

    void addMovie(Movie movie, City city){
        allMovies.add(movie);

        List<Movie> movies = cityWiseMovie.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        cityWiseMovie.put(city,movies);
    }

     Movie getMovieByName(String movieName){
        for(Movie movie: allMovies){
            if(Objects.equals(movie.name, movieName))
                return movie;
        }
        return null;
    }
    //CRUD operation on

}
