package LLDPractice.Uber;

import LLDPractice.Uber.Enum.RideStatus;
import LLDPractice.Uber.Enum.VehicleType;
import LLDPractice.Uber.User.Driver;
import LLDPractice.Uber.User.Rider;

import java.util.UUID;

public class Ride {
    UUID rideId;
    int fair;
    int time;
    Rider rider;
    Driver driver;
    Location start;
    Location end;
    RideStatus rideStatus;

    public Ride(Location start, Location end, int time, Rider rider){
        this.start = start;
        this.end = end;
        this.rideId = UUID.randomUUID();
        this.time = time;
        this.rider = rider;
        this.rideStatus = RideStatus.REQUESTED;
    }

    public void setFair(int amount){
        this.fair = fair;
    }
}
