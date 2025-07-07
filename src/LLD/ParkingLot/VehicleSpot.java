package LLD.ParkingLot;

import LLD.ParkingLot.Enums.VehicleType;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class VehicleSpot {
    public String spotId;
    public VehicleType vehicleType;
    public int floor;
}
