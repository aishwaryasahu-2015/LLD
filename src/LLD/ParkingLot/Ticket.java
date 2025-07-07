package LLD.ParkingLot;

import java.util.Date;

public class Ticket {
    VehicleSpot vehicleSpot;
    Date inTime;
    Date outTime;

    public Ticket(VehicleSpot vehicleSpot){
        this.vehicleSpot = vehicleSpot;
        this.inTime = new Date();
    }
}
