package LowLevelDesign.Splitwise;

import LowLevelDesign.Splitwise.User.User;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class UserExpenseBalanceSheet {
    Map<String,Balance> userVsBalance;
    double totalExpense;
    double totalPayment;
    double totalOwe;
    double totalGetBack;

    public UserExpenseBalanceSheet(){
        this.userVsBalance = new HashMap<>();
        this.totalExpense = 0;
        this.totalOwe = 0;
        this.totalGetBack = 0;
    }
}
