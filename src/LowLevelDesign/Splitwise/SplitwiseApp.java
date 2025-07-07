package LowLevelDesign.Splitwise;

import LowLevelDesign.Splitwise.Group.GroupController;
import LowLevelDesign.Splitwise.User.User;
import LowLevelDesign.Splitwise.User.UserController;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SplitwiseApp {
    UserController userController;
    GroupController groupController;
    BalanceSheetController balanceSheetController;

    public void splitwiseActions(){


    }

    public void setUpUserAndGroups(){

    }

    public void addUsersToSplitwiseApp(){
        User user1 = new User();
    }
}
