package LowLevelDesign.ParkingLot;

import java.util.Map;

public abstract class ParkingSpot {
    int floorNumber;
    int spotId;
    Vehicle vehicle;
    double firstHourCharges;
    double subsequentHourCharges;

    public ParkingSpot(int floor, int spotId, Vehicle vehicle, Map<ChargeStructure, Double> chargeStructureMap){
        this.floorNumber = floor;
        this.spotId = spotId;
        this.vehicle = vehicle;
        this.firstHourCharges = chargeStructureMap.get(ChargeStructure.FIRST_HOUR);
        this.subsequentHourCharges = chargeStructureMap.get(ChargeStructure.SUBSEQUENT_HOUR);
    }

    public double calculatePayment(int totalHours) {
        System.out.println("Total Hours: " + totalHours);
        double payable = this.firstHourCharges + this.subsequentHourCharges*(totalHours-1);
        System.out.println("Payable: " + payable);
        return payable;
    }
}
