package LowLevelDesign.ParkingLot;

import java.util.Map;

public class FourWheelerSpot extends ParkingSpot{
    public FourWheelerSpot(int floor, int spotId, Vehicle vehicle, Map<ChargeStructure, Double> chargeStructure){
        super(floor, spotId, vehicle, chargeStructure);
    }
}
