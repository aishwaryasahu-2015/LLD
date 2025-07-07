package LLD.ParkingLot;

import java.util.HashSet;
import java.util.Set;

public class Floor {
    int floorNumber;
    int totalFourWheelerSpots;
    int totalTwoWheelerSpots;
    Set<String> availableFourWheelerSpotIds;
    Set<String> availableTwoWheelerSpotIds;

    public Floor(int floorNumber, int totalFourWheelerSpots, int totalTwoWheelerSpots){
        this.floorNumber = floorNumber;
        this.totalFourWheelerSpots = totalFourWheelerSpots;
        this.totalTwoWheelerSpots = totalTwoWheelerSpots;

        this.availableFourWheelerSpotIds = new HashSet<>();
        this.availableTwoWheelerSpotIds = new HashSet<>();

        for(int i=0;i<totalFourWheelerSpots;i++){
            this.availableFourWheelerSpotIds.add(String.valueOf(i));
        }

        for(int i=0;i<totalTwoWheelerSpots;i++){
            this.availableTwoWheelerSpotIds.add(String.valueOf(i));
        }
    }
}
