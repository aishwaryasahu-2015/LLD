package LowLevelDesign.ParkingLot;

public class ParkingSpotFactory {
    public ParkingSpot createParkingSpot(VehicleType vehicleType, int floor, int spotId, Vehicle vehicle, Config config){
        switch (vehicleType){
            case TWO_WHEELER:
                return new TwoWheelerSpot(floor, spotId, vehicle, config.vehicleTypeToChargesMapping.get(vehicleType));
            case FOUR_WHEELER:
                return new FourWheelerSpot(floor, spotId, vehicle, config.vehicleTypeToChargesMapping.get(vehicleType));
            default:
                return null;
        }
    }
}
