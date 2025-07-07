package LowLevelDesign.ZoomCar;

import LowLevelDesign.ZoomCar.VehicleProduct.Vehicle;
import LowLevelDesign.ZoomCar.VehicleProduct.VehicleType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VehicleInventoryManagement {
    List<Vehicle> vehicles;
    //CRUD operations on Vehicle

    public VehicleInventoryManagement(List<Vehicle> vehicles){
        this.vehicles = vehicles;
    }

    public List<Vehicle> getVehicles(VehicleType vehicleType){
        //Add filter logic here
        return vehicles;
    }
}
