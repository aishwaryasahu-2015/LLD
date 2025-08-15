package LLDPractice.Uber.User;

import LLDPractice.Uber.Enum.UserType;
import LLDPractice.Uber.Enum.VehicleType;
import LLDPractice.Uber.Location;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Driver extends User{
    VehicleType vehicleType;
    @Setter
    Location currentLocation;
    @Setter
    boolean isAvailable;

    public Driver(String id, String name, VehicleType vehicleType){
        super(id, name);
        this.vehicleType = vehicleType;
        this.isAvailable = true;
    }
}
