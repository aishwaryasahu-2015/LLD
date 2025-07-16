package LowLevelDesign.ParkingLot;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Floor {
    int floorNumber;
    int twoWheelerSpots;
    int fourWheelerSpots;
    Set<Integer> availableTwoWheelerSpots;
    Set<Integer> availableFourWheelerSpots;
    Map<Integer,FourWheelerSpot> occupiedFourWheelerSpots;
    Map<Integer,TwoWheelerSpot> occupiedTwoWheelerSpots;

    public Floor(int floorNumber, int twoWheelerSpots, int fourWheelerSpots){
        this.floorNumber = floorNumber;
        this.twoWheelerSpots = twoWheelerSpots;
        this.fourWheelerSpots = fourWheelerSpots;

        this.availableTwoWheelerSpots = new HashSet<>();
        for(int i=0;i<this.twoWheelerSpots;i++){
            availableTwoWheelerSpots.add(i);
        }

        this.availableFourWheelerSpots = new HashSet<>();
        for(int i=0;i<this.fourWheelerSpots;i++){
            availableFourWheelerSpots.add(i);
        }

        this.occupiedTwoWheelerSpots = new HashMap<>();
        this.occupiedFourWheelerSpots = new HashMap<>();
    }


}
