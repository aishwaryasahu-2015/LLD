package LowLevelDesign.ParkingLot;

import java.util.Date;

public class Ticket {
    ParkingSpot parkingSpot;
    Date inTime;
    Date outTime;
    Invoice invoice;

    public Ticket(ParkingSpot parkingSpot){
        this.parkingSpot = parkingSpot;
        this.inTime = new Date();
        this.outTime = null;
        this.invoice = null;
    }
}
