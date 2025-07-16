package LowLevelDesign.ParkingLot;

import java.util.concurrent.TimeUnit;

import java.util.*;

public class ParkingLotManagementSystem {
    Config config;
    VehicleFactory vehicleFactory;
    ParkingSpotFactory parkingSpotFactory;
    Map<String, List<Ticket>> vehicleHistory;
    List<Floor> floorList;

    public ParkingLotManagementSystem(){
        this.config = new Config();
        this.floorList = new ArrayList<>();
        this.vehicleHistory = new HashMap<>();
        this.vehicleFactory = new VehicleFactory();
        this.parkingSpotFactory = new ParkingSpotFactory();
    }

    public void createFloor(int floorNumber, int twoWheelerSpots, int fourWheelerSpots){
        Floor floor = new Floor(floorNumber, twoWheelerSpots, fourWheelerSpots);
        this.floorList.add(floor);
    }

    public Ticket createParkingTicket(VehicleType vehicleType, String vehicleNumber){
        int floor=0;
        int spotId=-1;
        while(floor<floorList.size()){
            Floor curFloor = floorList.get(floor);
            switch (vehicleType){
                case TWO_WHEELER:{
                    if(!curFloor.availableTwoWheelerSpots.isEmpty()){
                        spotId =  curFloor.availableTwoWheelerSpots.iterator().next();
                        curFloor.availableTwoWheelerSpots.remove(spotId);
                    }
                    break;
                }
                case FOUR_WHEELER: {
                    if (!curFloor.availableFourWheelerSpots.isEmpty()) {
                        spotId = curFloor.availableFourWheelerSpots.iterator().next();
                        curFloor.availableFourWheelerSpots.remove(spotId);
                    }
                    break;
                }
                default:
                    break;
            }
            if(spotId != -1)
                break;
            floor++;
        }

        if(spotId == -1){
            throw new RuntimeException("No spot available");
        }

        Vehicle vehicle = this.vehicleFactory.createVehicle(vehicleType, vehicleNumber);
        ParkingSpot parkingSpot = this.parkingSpotFactory.createParkingSpot(vehicleType, floor, spotId, vehicle, config);
        Ticket ticket = new Ticket(parkingSpot);
        List<Ticket> ticketList = this.vehicleHistory.get(vehicleNumber);
        if(ticketList == null)
            ticketList = new ArrayList<>();
        ticketList.add(ticket);
        this.vehicleHistory.put(vehicle.vehicleNumber, ticketList);
        return ticket;
    }

    public void exit(String vehicleNumber){
        List<Ticket> ticketList = this.vehicleHistory.get(vehicleNumber);
        if(ticketList.isEmpty()){
            System.out.println("No Vehicle against the vehicle number: " + vehicleNumber);
            return;
        }
        Ticket ticket = ticketList.get(ticketList.size()-1);
        if(ticket.outTime != null)
            return;
        ticket.outTime = new Date();
        long diffInMillis = ticket.outTime.getTime() - ticket.inTime.getTime();
        long millisInHour = TimeUnit.HOURS.toMillis(1);
        int hours = (int) ((diffInMillis + millisInHour - 1) / millisInHour);

        double payable = ticket.parkingSpot.calculatePayment(hours);
        ticket.invoice = new Invoice(payable);
        this.makeSpotAvailable(ticket.parkingSpot);
    }

    public void makeSpotAvailable(ParkingSpot spot){
        if(spot instanceof TwoWheelerSpot){
            Floor floor = floorList.get(spot.floorNumber);
            floor.occupiedTwoWheelerSpots.remove(spot.spotId);
            floor.availableTwoWheelerSpots.add(spot.spotId);
        }
        if(spot instanceof FourWheelerSpot){
            Floor floor = floorList.get(spot.floorNumber);
            floor.occupiedFourWheelerSpots.remove(spot.spotId);
            floor.availableFourWheelerSpots.add(spot.spotId);
        }
    }
}
