package LLDPractice.Uber;

import LLDPractice.Uber.Enum.PaymentType;
import LLDPractice.Uber.Enum.RideStatus;
import LLDPractice.Uber.Util;
import LLDPractice.Uber.Enum.VehicleType;
import LLDPractice.Uber.User.Driver;
import LLDPractice.Uber.User.Rider;

import javax.swing.*;
import java.util.Map;

public class RideManagement {
    private Util util;

    public RideManagement(Util util){
        this.util = util;
    }
    public Ride createRide(Rider rider, VehicleType vehicleType, Location start, Location end){
        int time = getEstimatedTime(vehicleType, start, end);
        return new Ride(start, end, time, rider);
    }

    private int getEstimatedTime(VehicleType vehicleType, Location start, Location end){
        return util.getDistance(start,end)*2;
    }

    public void startTheRide(Ride ride, Driver driver){
        if(ride.rideStatus == RideStatus.REQUESTED){
            ride.driver =driver;
            ride.rideStatus = RideStatus.ONGOING;
            driver.setAvailable(false);
        }
    }

    public void endRide(Ride ride){
        if(ride.rideStatus == RideStatus.ONGOING)
            ride.rideStatus = RideStatus.COMPLETED;
    }

    public void initiatePayment(Ride ride, PaymentType paymentType){
        if(ride.rideStatus == RideStatus.COMPLETED){
            Payment paymentProcess = (paymentType == PaymentType.CASH ? new CashPayment(): new OnlinePayment());
            paymentProcess.makePayment(ride.fair);
        }
    }

    public void cancelRide(Ride ride){
        if(ride.rideStatus != RideStatus.COMPLETED)
            ride.rideStatus = RideStatus.CANCELLED;
    }

//    public void provideRating(UserType userType, String userId, int rating, Ride ride){
//
//    }
}
