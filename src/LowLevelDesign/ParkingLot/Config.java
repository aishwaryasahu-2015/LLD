package LowLevelDesign.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class Config {
    Map<VehicleType, Map<ChargeStructure, Double>> vehicleTypeToChargesMapping;

    public Config(){
        this.vehicleTypeToChargesMapping = new HashMap<>();
        Map<ChargeStructure,Double> chargeStructureMapTwoWheeler = new HashMap<>();
        chargeStructureMapTwoWheeler.put(ChargeStructure.FIRST_HOUR, 30.0);
        chargeStructureMapTwoWheeler.put(ChargeStructure.SUBSEQUENT_HOUR, 20.0);
        this.vehicleTypeToChargesMapping.put(VehicleType.TWO_WHEELER, chargeStructureMapTwoWheeler);

        Map<ChargeStructure,Double> chargeStructureMapFourWheeler = new HashMap<>();
        chargeStructureMapFourWheeler.put(ChargeStructure.FIRST_HOUR, 40.0);
        chargeStructureMapFourWheeler.put(ChargeStructure.SUBSEQUENT_HOUR, 25.0);
        this.vehicleTypeToChargesMapping.put(VehicleType.FOUR_WHEELER, chargeStructureMapFourWheeler);
    }

    public void makeChangesInPaymentStructure(VehicleType vehicleType, ChargeStructure chargeStructure, double amount){
     //to be implemented later
    }
}
