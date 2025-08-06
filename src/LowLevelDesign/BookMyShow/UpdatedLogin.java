import java.util.*;

enum Language {
    ENGLISH, HINDI, TAMIL, TELUGU
}

enum Genre {
    ACTION, COMEDY, DRAMA, HORROR
}

enum CityName {
    MUMBAI, DELHI, BANGALORE
}

enum PaymentStatus {
    SUCCESS, FAILED, PENDING
}

enum SeatType {
    REGULAR, PREMIUM, VIP
}

enum TheaterName {
    PVR, INOX, CINEPOLIS
}

abstract class User {
    int userId;
    String name;
}

class Admin extends User {}

class Customer extends User {}

class BookMyShowApp {
    Map<User, List<Ticket>> userToTickets = new HashMap<>();
    List<City> cities = new ArrayList<>();

    public void initialize() {
        // Create cities
        City mumbai = new City(CityName.MUMBAI);
        City delhi = new City(CityName.DELHI);
        City bangalore = new City(CityName.BANGALORE);

        cities.add(mumbai);
        cities.add(delhi);
        cities.add(bangalore);

        // Add theaters to Mumbai
        Theater pvrMumbai = new Theater(TheaterName.PVR, "Andheri", 2);
        Theater inoxMumbai = new Theater(TheaterName.INOX, "Bandra", 1);

        mumbai.addTheater(pvrMumbai);
        mumbai.addTheater(inoxMumbai);

        // Add screens
        Screen screen1 = new Screen(1);
        Screen screen2 = new Screen(2);

        pvrMumbai.addScreen(screen1);
        pvrMumbai.addScreen(screen2);

        // Add a movie
        Movie movie = new Movie("Inception", Language.ENGLISH, Genre.ACTION);
        mumbai.addMovie(movie);

        // Add show
        Calendar cal = Calendar.getInstance();
        cal.set(2025, Calendar.AUGUST, 1, 18, 0);
        Date start = cal.getTime();
        cal.set(2025, Calendar.AUGUST, 1, 20, 30);
        Date end = cal.getTime();

        Show show = new Show(movie, CityName.MUMBAI, pvrMumbai, screen1, start, end);
        pvrMumbai.addShow(movie, show);
    }
}

class City {
    CityName cityName;
    Set<Theater> theaters = new HashSet<>();
    List<Movie> movies = new ArrayList<>();
    Map<Movie, List<Theater>> movieToTheaters = new HashMap<>();

    public City(CityName cityName) {
        this.cityName = cityName;
    }

    public void addTheater(Theater theater) {
        theaters.add(theater);
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }
}

class Movie {
    String name;
    Language language;
    Genre genre;

    public Movie(String name, Language language, Genre genre) {
        this.name = name;
        this.language = language;
        this.genre = genre;
    }
}

class Theater {
    TheaterName name;
    String address;
    int screenCount;
    Map<Movie, List<Show>> movieToShows = new HashMap<>();
    Map<Integer, List<TimeSlot>> screenToTimeSlots = new HashMap<>();
    Map<Integer, Screen> screens = new HashMap<>();

    public Theater(TheaterName name, String address, int screenCount) {
        this.name = name;
        this.address = address;
        this.screenCount = screenCount;
    }

    public void addScreen(Screen screen) {
        screens.put(screen.screenId, screen);
    }

    public void addShow(Movie movie, Show show) {
        movieToShows.computeIfAbsent(movie, k -> new ArrayList<>()).add(show);
        screenToTimeSlots.computeIfAbsent(show.screen.screenId, k -> new ArrayList<>())
                .add(new TimeSlot(show.startTime, show.endTime));
    }
}

class Screen {
    int screenId;
    List<Seat> seats = new ArrayList<>();

    public Screen(int screenId) {
        this.screenId = screenId;
    }
}

class Show {
    Movie movie;
    CityName cityName;
    Theater theater;
    Screen screen;
    Date startTime;
    Date endTime;
    Set<Seat> availableSeats = new HashSet<>();
    Map<SeatType, Double> seatPricing = new HashMap<>();

    public Show(Movie movie, CityName cityName, Theater theater, Screen screen, Date startTime, Date endTime) {
        this.movie = movie;
        this.cityName = cityName;
        this.theater = theater;
        this.screen = screen;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public synchronized boolean bookSeats(List<Seat> requestedSeats) {
        if (availableSeats.containsAll(requestedSeats)) {
            availableSeats.removeAll(requestedSeats);
            return true;
        }
        return false;
    }

    public synchronized void updateSeatPrice(SeatType seatType, double newPrice) {
        seatPricing.put(seatType, newPrice);
    }

    public synchronized double calculatePrice(List<Seat> selectedSeats) {
        double total = 0;
        for (Seat seat : selectedSeats) {
            total += seatPricing.getOrDefault(seat.seatType, seat.price);
        }
        return total;
    }
}

class TimeSlot {
    Date startTime;
    Date endTime;

    public TimeSlot(Date startTime, Date endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

abstract class Seat {
    int seatId;
    SeatType seatType;
    double price;
}

class SeatFactory {
    public static Seat createSeat(int seatId, SeatType type, double price) {
        return new ConcreteSeat(seatId, type, price);
    }
}

class ConcreteSeat extends Seat {
    public ConcreteSeat(int seatId, SeatType type, double price) {
        this.seatId = seatId;
        this.seatType = type;
        this.price = price;
    }
}

class Invoice {
    Map<SeatType, Integer> seatTypeCount = new HashMap<>();
    double totalAmount;
}

class Ticket {
    Invoice invoice;
    Show show;
    List<Seat> seats;
}
