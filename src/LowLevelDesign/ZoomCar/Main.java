package LowLevelDesign.ZoomCar;

import LowLevelDesign.ZoomCar.VehicleProduct.Car;
import LowLevelDesign.ZoomCar.VehicleProduct.Vehicle;
import LowLevelDesign.ZoomCar.VehicleProduct.VehicleType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String args[]){
        System.out.println("This is a car rental system");

        List<User> users = addUsers();
        List<Vehicle> vehicles = addVehicle();
        List<Store> stores = addStores(vehicles);

        VehicleRentalSystem rentalSystem = new VehicleRentalSystem(users, stores);
        // 1. Uers comes
        User user = users.get(0);

        //2. User serach bases on locations return store
        Location location = new Location(123456, "Bangalore", "Karnataka", "India");
        Store store = rentalSystem.getStore(location);

        //3. get all the vehicle of the store
        List<Vehicle> vehicleList = store.getVehicles(VehicleType.CAR);

        //4. reserve a particular vehicle
        Reservation reservation = store.createReservation(vehicleList.get(0), user, new Date("25-06-2025"), new Date("28-06-2025"),
                location, location);
        //5. generate invoice

        //6. make payment

        //7. trip completed submit the vehicle and change status

    }

    public static List<User> addUsers(){
        List<User> users = new ArrayList<>();
        User user1 = new User();

        user1.setUserId(1);
        user1.setDrivingLicence("DL123456");
        users.add(user1);
        return users;
    }

    public static List<Vehicle> addVehicle(){
        List<Vehicle> vehicles = new ArrayList<>();
        Car car1 = new Car();
        Car car2 = new Car();

        car1.setVehicleId(1);
        car1.setVehicleType(VehicleType.CAR);

        car2.setVehicleId(2);
        car2.setVehicleType(VehicleType.CAR);

        vehicles.add(car1);
        vehicles.add(car2);

        return vehicles;
    }

    public static List<Store> addStores(List<Vehicle> vehicles){
        List<Store> stores = new ArrayList<>();

        Store store1 = new Store();
        store1.setStoreId(1);
        store1.setVehicle(vehicles);
        stores.add(store1);

        return stores;
    }
}
