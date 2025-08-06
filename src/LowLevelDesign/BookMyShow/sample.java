//package LowLevelDesign.BookMyShow;
//import java.util.*;
//
//public class sample {
//}
//
//
//
//// Enums
//enum Language { HINDI, ENGLISH, TAMIL, TELUGU }
//enum Genre { ACTION, DRAMA, COMEDY, HORROR }
//enum SeatType { REGULAR, PREMIUM, VIP }
//enum CityName { MUMBAI, DELHI, BANGALORE }
//enum TheaterName { PVR, INOX, CINEPOLIS }
//enum PaymentStatus { SUCCESS, FAILED }
//enum SeatStatus { AVAILABLE, BLOCKED, BOOKED }
//
//// Abstract User
//abstract class User {
//    int id;
//    String name;
//}
//
//class Admin extends User {
//    // Admin-specific actions
//}
//
//class Customer extends User {
//    List<Ticket> tickets = new ArrayList<>();
//}
//
//class BookMyShowApp {
//    Map<Customer, List<Ticket>> userToTickets = new HashMap<>();
//    List<City> cities = new ArrayList<>();
//    // Singleton or bootstrapper class
//}
//
//class City {
//    CityName cityName;
//    Set<Theater> theaters = new HashSet<>();
//    Map<Movie, List<Theater>> movieToTheaterMap = new HashMap<>();
//
//    List<Movie> getMoviesByLanguage(Language language) {
//        List<Movie> filtered = new ArrayList<>();
//        for (Movie movie : movieToTheaterMap.keySet()) {
//            if (movie.language == language) filtered.add(movie);
//        }
//        return filtered;
//    }
//}
//
//class Movie {
//    String name;
//    Language language;
//    Genre genre;
//}
//
//class Theater {
//    TheaterName name;
//    String address;
//    Map<Movie, List<Show>> movieToShowsMap = new HashMap<>();
//    Map<String, List<TimeSlot>> screenToShowSchedule = new HashMap<>();
//    Map<String, Screen> screens = new HashMap<>();
//
//    boolean isScreenAvailable(String screenId, TimeSlot newSlot) {
//        for (TimeSlot slot : screenToShowSchedule.getOrDefault(screenId, new ArrayList<>())) {
//            if (slot.overlaps(newSlot)) return false;
//        }
//        return true;
//    }
//
//    void addShow(Movie movie, Show show, String screenId) throws Exception {
//        TimeSlot slot = new TimeSlot(show.startTime, show.endTime);
//        if (!isScreenAvailable(screenId, slot)) throw new Exception("Show time conflict");
//
//        movieToShowsMap.computeIfAbsent(movie, k -> new ArrayList<>()).add(show);
//        screenToShowSchedule.computeIfAbsent(screenId, k -> new ArrayList<>()).add(slot);
//    }
//}
//
//class Screen {
//    String screenId;
//    List<Seat> seats;
//
//    Screen(String screenId, int regular, int premium, int vip) {
//        this.screenId = screenId;
//        this.seats = SeatFactory.createSeats(regular, premium, vip);
//    }
//}
//
//class Show {
//    Movie movie;
//    String screenId;
//    Date startTime, endTime;
//    Screen screen;
//    Map<Integer, Seat> seatMap;
//
//    public Show(Movie movie, Screen screen, Date start, Date end) {
//        this.movie = movie;
//        this.screen = screen;
//        this.screenId = screen.screenId;
//        this.startTime = start;
//        this.endTime = end;
//        this.seatMap = new HashMap<>();
//        for (Seat seat : screen.seats) {
//            this.seatMap.put(seat.id, new Seat(seat)); // clone seats
//        }
//    }
//
//    public synchronized boolean bookSeats(List<Integer> seatIds) {
//        for (int id : seatIds) {
//            if (seatMap.get(id).status != SeatStatus.AVAILABLE) return false;
//        }
//        for (int id : seatIds) seatMap.get(id).status = SeatStatus.BOOKED;
//        return true;
//    }
//}
//
//class Seat {
//    int id;
//    SeatType type;
//    double price;
//    SeatStatus status;
//
//    Seat(int id, SeatType type, double price) {
//        this.id = id;
//        this.type = type;
//        this.price = price;
//        this.status = SeatStatus.AVAILABLE;
//    }
//
//    Seat(Seat other) { // copy constructor for cloning
//        this.id = other.id;
//        this.type = other.type;
//        this.price = other.price;
//        this.status = SeatStatus.AVAILABLE;
//    }
//}
//
//class SeatFactory {
//    public static List<Seat> createSeats(int regular, int premium, int vip) {
//        List<Seat> seats = new ArrayList<>();
//        int id = 1;
//        for (int i = 0; i < regular; i++) seats.add(new Seat(id++, SeatType.REGULAR, 100));
//        for (int i = 0; i < premium; i++) seats.add(new Seat(id++, SeatType.PREMIUM, 150));
//        for (int i = 0; i < vip; i++) seats.add(new Seat(id++, SeatType.VIP, 200));
//        return seats;
//    }
//}
//
//class Ticket {
//    Show show;
//    List<Seat> bookedSeats;
//    Invoice invoice;
//    Date bookingTime;
//}
//
//class Invoice {
//    double totalAmount;
//    Map<SeatType, Integer> categoryCount;
//    PaymentStatus status;
//}
//
//class TimeSlot {
//    Date start, end;
//    TimeSlot(Date start, Date end) {
//        this.start = start;
//        this.end = end;
//    }
//    boolean overlaps(TimeSlot other) {
//        return this.start.before(other.end) && other.start.before(this.end);
//    }
//}