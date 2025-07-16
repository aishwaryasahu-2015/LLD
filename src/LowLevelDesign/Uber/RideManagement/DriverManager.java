package LowLevelDesign.Uber.RideManagement;

import LowLevelDesign.Uber.Coordinates;
import LowLevelDesign.Uber.Registration.Driver;
import LowLevelDesign.Uber.Registration.Rider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class DriverManager {
    Map<String, Driver> driversMap;
    int minimumDriverReturn=3;

    public DriverManager(Map<String, Driver> driversMap){
        this.driversMap = driversMap;
    }

    public List<Driver> getNearbyDrivers(Coordinates destination){
        List<Driver> driverList = new ArrayList<>();
        PriorityQueue<Driver> priorityQueue = new PriorityQueue<>((d1, d2) -> {
            double dist1 = Math.pow((d1.coordinates.x - destination.x),2) + Math.pow((d1.coordinates.y - destination.y),2);
            double dist2 = Math.pow((d2.coordinates.x - destination.x),2) + Math.pow((d2.coordinates.y - destination.y),2);
            return (int) (dist1 - dist2);
        });

        for (Map.Entry<String, Driver> entry : driversMap.entrySet()) {
            priorityQueue.add(entry.getValue());
            if(priorityQueue.size()>this.minimumDriverReturn){
                Driver driver = priorityQueue.peek();
                System.out.println("Coordinates for driver: " + driver.coordinates.x + ", " + driver.coordinates.y);
                priorityQueue.poll();
            }
        }

        while(!priorityQueue.isEmpty()){
            Driver driver = priorityQueue.peek();
            System.out.println("Coordinates for driver: " + driver.coordinates.x + ", " + driver.coordinates.y);
            priorityQueue.poll();
            driverList.add(driver);
        }
        return driverList;
    }

    public List<Driver> requestRide(Rider requester, Coordinates source, Coordinates destination){
        List<Driver> nearByDrivers = getNearbyDrivers(source);
        RideRequest rideRequest = new RideRequest(source, destination, new RiderInfo(requester.name, requester.phoneNumber));
        for (Driver nearByDriver : nearByDrivers) {
            nearByDriver.rideRequestList.add(rideRequest);
        }
        return nearByDrivers;
    }

}
