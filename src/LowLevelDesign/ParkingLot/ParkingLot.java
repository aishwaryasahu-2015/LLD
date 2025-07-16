package LowLevelDesign.ParkingLot;

import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class ParkingLot {
    ParkingLotManagementSystem parkingLotManagementSystem;

    public ParkingLot(){
        this.parkingLotManagementSystem = new ParkingLotManagementSystem();
    }

    public static void main(String[] args){
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.init();
        parkingLot.parkingLotManagementSystem.createParkingTicket(VehicleType.TWO_WHEELER, "123456");
        parkingLot.parkingLotManagementSystem.createParkingTicket(VehicleType.FOUR_WHEELER, "123478");
        parkingLot.parkingLotManagementSystem.exit("123456");
        parkingLot.showParkingHistory("123456");
        parkingLot.showParkingHistory("123478");
    }

    private void init(){
        //Create floors
        this.parkingLotManagementSystem.createFloor(1,10,10);
        this.parkingLotManagementSystem.createFloor(2,20,10);
        this.parkingLotManagementSystem.createFloor(3,10,12);
        this.parkingLotManagementSystem.createFloor(4,10,10);
        this.parkingLotManagementSystem.createFloor(5,10,10);
    }

    private void showParkingHistory(String vehicleNumber){
       List<Ticket> ticketList = this.parkingLotManagementSystem.vehicleHistory.get(vehicleNumber);
       if(ticketList.isEmpty()){
           System.out.println("No History for the vehicle");
       }

       System.out.println("Ticket History of the Vehicle Number: " + vehicleNumber);
       for(Ticket ticket: ticketList){
           System.out.println(ticket.inTime);
           System.out.println(ticket.outTime);
           System.out.println(ticket.invoice==null ? "Noinvoice" : ticket.invoice.payable);
       }
    }
}
