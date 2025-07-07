package LowLevelDesign.ZoomCar;

import java.util.List;

public class VehicleRentalSystem {
    List<User> users;
    List<Store> stores;

    public VehicleRentalSystem(List<User> users, List<Store> stores){
        this.stores = stores;
        this.users = users;
    }

    public Store getStore(Location location){
        return stores.get(0);
    }
    //CRUD operations on stores and Users
}
