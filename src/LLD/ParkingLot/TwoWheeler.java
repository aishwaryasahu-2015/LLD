package LLD.ParkingLot;

import lombok.Getter;
import lombok.Setter;

@Getter
public class TwoWheeler extends Vehicle{
    double firstHourPrice = 30;
    double restPrice = 20;

    public TwoWheeler(User owner, String vehicleNumber){
        super(owner, vehicleNumber);
    }

    @Override
    public double calculatePrice(int diff){
       return firstHourPrice + (diff-1)*restPrice;
    }
}
