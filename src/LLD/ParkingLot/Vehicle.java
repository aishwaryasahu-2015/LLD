package LLD.ParkingLot;

public abstract class Vehicle {
    String vehicleNumber;
    User owner;
    Ticket ticket;

    public Vehicle(User owner, String vehicleNumber){
        this.owner = owner;
        this.vehicleNumber = vehicleNumber;
    }

    public void setTicket(Ticket ticket){
        this.ticket = ticket;
    }

    public abstract double calculatePrice(int diff);
}
