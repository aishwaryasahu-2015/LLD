package LowLevelDesign.BookMyShow.Seats;

import LowLevelDesign.BookMyShow.Enums.SeatType;

public class SeatFactory {
    public Seat createSeat(SeatType seatType){
        switch (seatType){
            case GOLD:
                return new Gold();
            case PLATINUM:
                return new Platinum();
            default:
                System.out.println("Please provide a valid seat type");
                return null;
        }
    }
}
