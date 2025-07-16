package LowLevelDesign.Uber.Registration;

import LowLevelDesign.Uber.Coordinates;
import jakarta.ws.rs.DefaultValue;
import lombok.Getter;
import lombok.Setter;

public abstract class User {
    public String name;
    public String phoneNumber;
    public Coordinates coordinates;

    @Getter
    @Setter
    @DefaultValue("false")
    Boolean isRegistered;

    public User(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void setCoordinates(int x, int y){
        this.coordinates = new Coordinates(x,y);
    }

    public abstract void validateUser();

}
