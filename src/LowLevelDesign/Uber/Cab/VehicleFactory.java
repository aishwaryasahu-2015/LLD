package LowLevelDesign.Uber.Cab;

public class VehicleFactory {
    public Vehicle createVehicle(VehicleType vehicleType, String vehicleNumber){
        switch (vehicleType){
            case UBER_GO:
                return new UberGo(vehicleNumber);
            case UBER_XL:
                return new UberXL(vehicleNumber);
            default:
                return null;
        }
    }
}
