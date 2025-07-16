package LowLevelDesign.Uber.Registration;


import java.util.HashMap;
import java.util.Map;

public class RegistrationController {
    public Map<String,Driver> driverMap;
    public Map<String,Rider> riderMap;
    UserFactory userFactory;

    public RegistrationController(){
        this.driverMap = new HashMap<>();
        this.riderMap = new HashMap<>();
        this.userFactory = new UserFactory();
    }

    public User registerUser(UserType userType, String name, String phoneNumber){
        User user = userFactory.createUser(userType, name, phoneNumber);
        user.validateUser();
        this.addUserInMap(user, userType);
        return user;
    }

    private void addUserInMap(User user, UserType userType){
        switch (userType){
            case RIDER:
                this.riderMap.put(user.phoneNumber, (Rider) user);
                break;
            case DRIVER:
                this.driverMap.put(user.phoneNumber, (Driver) user);
                break;
            default:
                System.out.println("Invalid userType: " + userType);
        }
    }
}
