package LLD.ParkingLot;

import lombok.Getter;

@Getter
public class FourWheeler extends Vehicle{
    double firstHourPrice = 50;
    double restPrice = 20;

    public FourWheeler(User owner, String vehicleNumber){
        super(owner, vehicleNumber);
    }

    @Override
    public double calculatePrice(int diff){
        return firstHourPrice + (diff-1)*restPrice;
    }
}
