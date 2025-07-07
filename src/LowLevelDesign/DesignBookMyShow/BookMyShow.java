package LowLevelDesign.DesignBookMyShow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BookMyShow {
    MovieController movieController;
    TheaterController theaterController;

    BookMyShow(){
        movieController = new MovieController();
        theaterController = new TheaterController();
    }

    public static void main(String args[]){
        BookMyShow bookMyShow = new BookMyShow();

        bookMyShow.initialize();

        bookMyShow.createBooking(City.BANGALORE, "Avengers");

    }

    private void initialize(){
        createMovies();
        createTheaters();
    }

    private void createMovies(){
        Movie movie1 = new Movie(100, "Metro In Dino", 122);
        Movie movie2 = new Movie(101, "Taare Zameen Par", 118);
        Movie movie3 = new Movie(102, "Avengers", 150);
        Movie movie4 = new Movie(103, "Fault In Our Stars", 125);
        movieController.addMovie(movie1, City.BANGALORE);
        movieController.addMovie(movie2, City.BANGALORE);
        movieController.addMovie(movie3, City.BANGALORE);
        movieController.addMovie(movie1, City.DELHI);
        movieController.addMovie(movie3, City.DELHI);
        movieController.addMovie(movie4, City.DELHI);
        movieController.addMovie(movie3, City.RAIPUR);
        movieController.addMovie(movie1, City.RAIPUR);
    }

    private void createTheaters(){
        Movie Avengers = movieController.getMovieByName("Avengers");
        Movie MetroInDino = movieController.getMovieByName("Metro In Dino");

        Theater inox = new Theater();
        inox.setTheaterId(1);
        inox.setCity(City.BANGALORE);
        inox.setScreens(createScreen());
        List<Show> inoxShows = new ArrayList<>();
        Show morningInoxShow = new Show(1, Avengers, inox.getScreens().get(0), 8);
        Show eveningInoxShow = new Show(2, MetroInDino, inox.getScreens().get(0), 16);

        inoxShows.add(morningInoxShow);
        inoxShows.add(eveningInoxShow);
        inox.setShows(inoxShows);


        Theater pvr = new Theater();
        inox.setTheaterId(2);
        inox.setCity(City.DELHI);
        inox.setScreens(createScreen());
        List<Show> pvrShows = new ArrayList<>();
        Show morningPvrShow = new Show(1, Avengers, inox.getScreens().get(0), 8);
        Show eveningPvrShow = new Show(2, MetroInDino, inox.getScreens().get(0), 16);

        pvrShows.add(morningPvrShow);
        pvrShows.add(eveningPvrShow);
        pvr.setShows(pvrShows);

    }

    private List<Screen> createScreen(){
        List<Screen> screens = new ArrayList<>();
        screens.add(new Screen());
        return screens;
    }

    private void createBooking(City city, String movieName){

    }
}
