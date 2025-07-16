package LowLevelDesign.Uber;

import LowLevelDesign.Uber.Registration.*;
import LowLevelDesign.Uber.RideManagement.DriverManager;

import java.util.List;

public class Uber {
    RegistrationController registrationController;
    DriverManager driverManager;

    public Uber(){
        this.registrationController = new RegistrationController();
        this.driverManager = new DriverManager(this.registrationController.driverMap);
    }

    public static void main(String[] args){
        Uber uberApp = new Uber();
        uberApp.registerUsers();

        Rider rider1 = uberApp.registrationController.riderMap.get("1111111110");
        System.out.println(uberApp.registrationController.driverMap.size());
        System.out.println(uberApp.registrationController.riderMap.size());
        List<Driver> drivers = uberApp.driverManager.requestRide(rider1,new Coordinates(14,89), new Coordinates(57, 455));
    }

    private void registerUsers(){
        User driver1 = this.registrationController.registerUser(UserType.DRIVER, "Driver1", "1234567890");
        driver1.setCoordinates(46,100);
        System.out.println(driver1.name);
        User driver2 = this.registrationController.registerUser(UserType.DRIVER, "Driver2", "1234567891");
        driver2.setCoordinates(500, 65);
        User driver3 = this.registrationController.registerUser(UserType.DRIVER, "Driver3", "1234567892");
        driver3.setCoordinates(340, 23);
        User driver4 = this.registrationController.registerUser(UserType.DRIVER, "Driver4", "1234567893");
        driver4.setCoordinates(120, 90);
        User driver5 = this.registrationController.registerUser(UserType.DRIVER, "Driver5", "1234567894");
        driver5.setCoordinates(100, 226);

        User rider1 = this.registrationController.registerUser(UserType.RIDER, "Rider1", "1111111110");
        User rider2 = this.registrationController.registerUser(UserType.RIDER, "Rider2", "1111111111");
        User rider3 = this.registrationController.registerUser(UserType.RIDER, "Rider3", "1111111112");
    }
}
