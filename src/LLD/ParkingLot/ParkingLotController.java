package LLD.ParkingLot;

import LLD.ParkingLot.Enums.VehicleType;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class ParkingLotController {
    List<Floor> floorList;
    Map<String,List<Ticket>> vehicleHistory;
    Map<String,Vehicle> vehicleMap;
    VehicleFactory vehicleFactory;

    public ParkingLotController(List<Floor> floorList){
        this.vehicleFactory = new VehicleFactory();
        this.floorList = floorList;
        this.vehicleHistory = new HashMap<>();
        this.vehicleMap = new HashMap<>();
    }

    public VehicleSpot getVehicleSpot(VehicleType vehicleType){
        switch (vehicleType){
            case TWO_WHEELER:
                for(int i=0;i<floorList.size();i++){
                    Floor curFloor = floorList.get(i);
                    if(!curFloor.availableTwoWheelerSpotIds.isEmpty()){
                        Iterator<String> iterator = curFloor.availableTwoWheelerSpotIds.iterator();
                        String spotId = iterator.next();
                        curFloor.availableTwoWheelerSpotIds.remove(spotId);
                        return new VehicleSpot(spotId, vehicleType, i);
                    }
                }
                 break;
            case FOUR_WHEELER:
                for(int i=0;i<floorList.size();i++){
                    Floor curFloor = floorList.get(i);
                    if(!curFloor.availableFourWheelerSpotIds.isEmpty()){
                        Iterator<String> iterator = curFloor.availableFourWheelerSpotIds.iterator();
                        String spotId = iterator.next();
                        curFloor.availableFourWheelerSpotIds.remove(spotId);
                        return new VehicleSpot(spotId, vehicleType, i);
                    }
                }
                break;
            default:
                System.out.println("The vehicle type is not supported");
                return null;
        }
        return null;
    }

    public Vehicle createVehicle(User user, VehicleType vehicleType, String vehicleNumebr){
        return vehicleFactory.getVehicle(user, vehicleType, vehicleNumebr);
    }

    public void assignVehicleSpot(User user, VehicleType vehicleType, String vehicleNumebr){
        VehicleSpot spot = getVehicleSpot(vehicleType);
        if(spot != null){
            Ticket ticket = new Ticket(spot);
            Vehicle vehicle = this.createVehicle(user, vehicleType, vehicleNumebr);
            vehicle.setTicket(ticket);
            if(vehicleHistory.containsKey(vehicleNumebr)){
                vehicleHistory.get(vehicleNumebr).add(ticket);
            }else{
                vehicleHistory.put(vehicleNumebr,new ArrayList<>((Collection) ticket));
            }
            vehicleMap.put(vehicleNumebr, vehicle);
        }
    }

    public void exitVehicle(String vehicleNumber){
        List<Ticket> ticketList = vehicleHistory.get(vehicleNumber);
        if(ticketList.isEmpty()){
            System.out.println("Invalid vehicleNumber");
        }
        Ticket ticket = ticketList.get(ticketList.size()-1);
        //outTime Check
        VehicleSpot vehicleSpot = ticket.vehicleSpot;
        String spotId = vehicleSpot.spotId;
        int floor = vehicleSpot.floor;
        VehicleType vehicleType = vehicleSpot.vehicleType;
        switch (vehicleType){
            case TWO_WHEELER:
                floorList.get(floor).availableTwoWheelerSpotIds.add(spotId);
                break;
            case FOUR_WHEELER:
                floorList.get(floor).availableFourWheelerSpotIds.add(spotId);
                break;
            default:
                break;
        }
       generateInvoice(vehicleMap.get(vehicleNumber));
    }

    public void generateInvoice(Vehicle vehicle){
        Ticket ticket = vehicle.ticket;
        ticket.outTime = new Date();
        double price = vehicle.calculatePrice(getHr(ticket.inTime, ticket.outTime));
        System.out.println("Ticket price is: " + price);
    }

    public int getHr(Date inTime, Date outTime){
        Instant startInstant = inTime.toInstant();
        Instant endInstant = outTime.toInstant();

        // Calculate duration
        Duration duration = Duration.between(startInstant, endInstant);
        long minutes = duration.toMinutes();

        // Convert to ceiling hours
        return (int) Math.ceil(minutes / 60.0);
    }
}
