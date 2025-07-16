package LLD.ParkingLot;

import LLD.ParkingLot.Enums.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    ParkingLotController parkingLotController;

    public ParkingLot(ParkingLotController parkingLotController){
        this.parkingLotController = parkingLotController;
    }

    public static void main(String args[]){
        List<Floor> floorList = createFloors(5, 10, 20);
        ParkingLot parkingLotDriver = new ParkingLot(new ParkingLotController(floorList));
        User user1 = new User("aishwarya", "US001");
        parkingLotDriver.parkingLotController.assignVehicleSpot(user1, VehicleType.TWO_WHEELER, "KA1234");
        parkingLotDriver.parkingLotController.exitVehicle("KA1234");
    }

    public static List<Floor> createFloors(int totalFloor, int totalFourWheelerSpots, int totalTwoWheelerSpots){
        List<Floor> floorList = new ArrayList<>();
        for(int i=0;i<totalFloor; i++){
            Floor floor = new Floor(i, totalFourWheelerSpots, totalTwoWheelerSpots);
            floorList.add(floor);
        }
        return floorList;
    }
}
