package LLD.ParkingLot;

import LLD.ParkingLot.Enums.VehicleType;

public class VehicleFactory {
    public Vehicle getVehicle(User vehicleOwner,VehicleType vehicleType, String vehicleNumber){
        switch (vehicleType){
            case TWO_WHEELER:
                return new TwoWheeler(vehicleOwner, vehicleNumber);
            case FOUR_WHEELER:
                return new FourWheeler(vehicleOwner, vehicleNumber);
            default:
                return null;
        }
    }
}
