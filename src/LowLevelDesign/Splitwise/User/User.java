package LowLevelDesign.Splitwise.User;

import LowLevelDesign.Splitwise.UserExpenseBalanceSheet;
import lombok.Getter;
import lombok.Setter;

@Getter
public class User {
    String userId;
    String userName;
    UserExpenseBalanceSheet userExpenseBalanceSheet;

    public User(String id, String userName){
        this.userId = id;
        this.userName = userName;
        userExpenseBalanceSheet = new UserExpenseBalanceSheet();
    }

}
