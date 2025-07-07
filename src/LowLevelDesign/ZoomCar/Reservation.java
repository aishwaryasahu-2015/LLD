package LowLevelDesign.ZoomCar;

import LowLevelDesign.ZoomCar.VehicleProduct.Status;
import LowLevelDesign.ZoomCar.VehicleProduct.Vehicle;

import java.util.Date;
import java.util.UUID;

public class Reservation {
    int reservationId; //generated at the time of reservation
    Vehicle vehicleReserved;
    User user;
    Date reservationDate;
    Date bookedFrom;
    Date bookedTill;
    Long fromTimeStamp;
    Long tillTimeStamp;
    Location pickupLocation;
    Location dropLocation;

    public Reservation(Vehicle vehicle, User user, Date bookedFrom, Date bookedTill,
                              Location pickupLocation, Location dropLocation){
        vehicle.setStatus(Status.INACTIVE);
        this.vehicleReserved = vehicle;
        this.user = user;
        this.bookedFrom = bookedFrom;
        this.bookedTill = bookedTill;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.reservationDate = new Date();
        this.reservationId = 1234;
    }
}
