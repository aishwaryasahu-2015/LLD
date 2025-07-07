package LowLevelDesign.ZoomCar;

public class Location {
    String address;
    String city;
    String state;
    String country;
    int pincode;

    public Location(int pincode, String city, String state, String country){
        this.pincode = pincode;
        this.city = city;
        this.state = state;
        this.country = country;
    }
}
