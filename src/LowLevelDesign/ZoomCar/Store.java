package LowLevelDesign.ZoomCar;

import LowLevelDesign.ZoomCar.VehicleProduct.Vehicle;
import LowLevelDesign.ZoomCar.VehicleProduct.VehicleType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


public class Store {

    @Setter
    int storeId;

    Location location;

    List<Reservation> reservationList;

    VehicleInventoryManagement vehicleInventoryManagement;

    public void setVehicle(List<Vehicle> vehicles){
        vehicleInventoryManagement = new VehicleInventoryManagement(vehicles);
    }

    public List<Vehicle> getVehicles(VehicleType vehicleType){
        return vehicleInventoryManagement.getVehicles(vehicleType);
    }

    public Reservation createReservation(Vehicle vehicle, User user, Date bookedFrom, Date bookedTill,
                                         Location pickupLocation, Location dropLocation){
        Reservation reservation = new Reservation(vehicle, user, new Date("25-06-2025"), new Date("28-06-2025"),
                location, location);
        reservationList.add(reservation);
        return reservation;
    }
}
