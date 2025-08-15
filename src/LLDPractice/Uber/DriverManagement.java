package LLDPractice.Uber;

import LLDPractice.Uber.Enum.VehicleType;
import LLDPractice.Uber.User.Driver;

import java.util.List;
import java.util.Map;

public class DriverManagement {
    Map<VehicleType, List<String>> vehicleTypeToDriverList;
    Map<String, Driver> drivermap;
    Util util;

    public DriverManagement(Map<VehicleType, List<String>> vehicleTypeToDriverList, Map<String, Driver> drivermap, Util util) {
        this.vehicleTypeToDriverList = vehicleTypeToDriverList;
        this.drivermap = drivermap;
        this.util = util;
    }

    public Driver getDriver(VehicleType vehicleType, Location location) {
        List<String> driverIds = vehicleTypeToDriverList.get(vehicleType);
        int distance = Integer.MAX_VALUE;
        Driver driver = null;
        for (int i = 0; i < driverIds.size(); i++) {
            Driver curDriver = drivermap.get(driverIds.get(i));
            int curDistance = util.getDistance(location, curDriver.getCurrentLocation());
            System.out.println(curDistance);
            System.out.println(curDriver.getId());
            if (curDistance < distance && curDriver.isAvailable()) {
                driver = curDriver;
                distance = getDistance(location, curDriver.getCurrentLocation());
            }
        }
        return driver;
    }

    private int getDistance(Location start, Location end) {
        return (int) Math.ceil(Math.pow(Math.pow(end.latitude - start.latitude, 2) + Math.pow(end.longitude - start.longitude, 2), 0.5));
    }
}
