package LowLevelDesign.BookMyShow;

import LowLevelDesign.BookMyShow.Seats.Seat;

import java.util.List;

public class Ticket {
    int ticketId;
    Show show;
    List<Seat> seatList;
    Invoice invoice;
}
