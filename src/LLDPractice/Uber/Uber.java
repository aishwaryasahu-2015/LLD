package LLDPractice.Uber;

import LLDPractice.Uber.Enum.PaymentType;
import LLDPractice.Uber.Enum.VehicleType;
import LLDPractice.Uber.User.Driver;
import LLDPractice.Uber.User.Rider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Uber {
    Util util;
    Map<String, Rider> riderMap;
    Map<VehicleType, List<String>> vehicleTypeToDriverList;
    Map<String, Driver> drivermap;
    RideManagement rideManagement;
    DriverManagement driverManagement;
    PricingService pricingService;

    public Uber() throws IOException {
        this.util = new Util();
        this.riderMap = new HashMap<>();
        this.vehicleTypeToDriverList = new HashMap<>();
        this.drivermap = new HashMap<>();
        this.pricingService = new PricingService("/Users/aishwarya.sahu/IdeaProjects/LLD/src/LLDPractice/Uber/pricing.json");
        this.rideManagement = new RideManagement(util);
        this.driverManagement = new DriverManagement(vehicleTypeToDriverList, drivermap, util);
    }

    public static void main(String[] args) throws IOException {
        Uber uber = new Uber();
        uber.initialize();
        Rider rider = uber.riderMap.get("R001");
        Location start = new Location(123, 324);
        Location end = new Location(543, 765);
        Ride ride = uber.rideManagement.createRide(rider, VehicleType.ECONOMY, start, end);
        int estimatedFair = uber.getEstimatedFair(VehicleType.ECONOMY, start, end);
        ride.setFair(estimatedFair);
        Driver driver = uber.driverManagement.getDriver(VehicleType.ECONOMY, ride.start);
        System.out.println(driver.getId());
        uber.rideManagement.startTheRide(ride, driver);
        uber.rideManagement.endRide(ride);
        uber.rideManagement.initiatePayment(ride, PaymentType.CASH);
    }

    public void initialize(){
        Rider us1= new Rider( "R001", "Rider1");
        Rider us2=  new Rider( "R002", "Rider2");
        Rider us3= new Rider( "R003", "Rider3");
        this.riderMap.put("R001",us1);
        this.riderMap.put("R002",us2);
        this.riderMap.put("R003",us3);

        Driver us4= new Driver("D001", "Driver1", VehicleType.PREMIUM);
        Driver us5= new Driver("D002", "Driver2", VehicleType.ECONOMY);
        Driver us6= new Driver("D003", "Driver3", VehicleType.XL);
        Driver us7= new Driver("D004", "Driver4", VehicleType.PREMIUM);
        Driver us8= new Driver("D005", "Driver5", VehicleType.ECONOMY);
        Driver us9= new Driver("D006", "Driver6", VehicleType.XL);

        us4.setCurrentLocation(new Location(123, 456));
        us5.setCurrentLocation(new Location(789, 1011));
        us6.setCurrentLocation(new Location(1213, 543));
        us7.setCurrentLocation(new Location(231, 876));
        us8.setCurrentLocation(new Location(2309, 456));
        us9.setCurrentLocation(new Location(365, 876));

        this.drivermap.put("D001",us4);
        this.drivermap.put("D002",us5);
        this.drivermap.put("D003",us6);
        this.drivermap.put("D004",us7);
        this.drivermap.put("D005",us8);
        this.drivermap.put("D006",us9);

        List<String> driverlist1 = this.vehicleTypeToDriverList.getOrDefault(VehicleType.PREMIUM, new ArrayList<>());
        driverlist1.add("D001");
        driverlist1.add("D004");
        this.vehicleTypeToDriverList.put(VehicleType.PREMIUM, driverlist1);

        List<String> driverlist2 = this.vehicleTypeToDriverList.getOrDefault(VehicleType.ECONOMY, new ArrayList<>());
        driverlist2.add("D002");
        driverlist2.add("D005");
        this.vehicleTypeToDriverList.put(VehicleType.ECONOMY, driverlist2);

        List<String> driverlist3 = this.vehicleTypeToDriverList.getOrDefault(VehicleType.XL, new ArrayList<>());
        driverlist3.add("D003");
        driverlist3.add("D006");
        this.vehicleTypeToDriverList.put(VehicleType.XL, driverlist3);
    }

    private int getEstimatedFair(VehicleType vehicleType, Location start, Location end){
        int baseFair = this.pricingService.getPricing(vehicleType).getBaseFare();
        int perKmFair = this.pricingService.getPricing(vehicleType).getPerKmPrice();
        return baseFair + perKmFair*(util.getDistance(start,end)-1);
    }
}
