package LowLevelDesign.Uber.Registration;

public class UserFactory {
    public User createUser(UserType userType, String name, String phoneNumber){
        switch (userType){
            case DRIVER:
                return new Driver(name, phoneNumber);
            case RIDER:
                return new Rider(name, phoneNumber);
            default:
                return null;
        }
    }
}
