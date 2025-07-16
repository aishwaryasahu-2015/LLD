package LowLevelDesign.ParkingLot;

import java.util.Map;

public class TwoWheelerSpot extends ParkingSpot{
    public TwoWheelerSpot(int floor, int spotId, Vehicle vehicle, Map<ChargeStructure, Double> chargeStructure){
        super(floor, spotId, vehicle, chargeStructure);
    }


}
