package LowLevelDesign.Splitwise.User;

import LowLevelDesign.Splitwise.UserExpenseBalanceSheet;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    String id;
    String name;
    UserExpenseBalanceSheet userExpenseBalanceSheet;
}
