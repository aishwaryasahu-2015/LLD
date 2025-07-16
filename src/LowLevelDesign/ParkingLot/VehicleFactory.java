package LowLevelDesign.ParkingLot;

public class VehicleFactory {
    public Vehicle createVehicle(VehicleType vehicleType, String vehicleNumber){
        switch (vehicleType){
            case TWO_WHEELER:
                return new TwoWheeler(vehicleNumber);
            case FOUR_WHEELER:
                return new FourWheeler(vehicleNumber);
            default:
                return null;
        }
    }
}
