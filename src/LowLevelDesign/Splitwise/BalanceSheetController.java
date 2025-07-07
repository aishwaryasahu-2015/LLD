package LowLevelDesign.Splitwise;

import LowLevelDesign.Splitwise.Expense.Split.Split;
import LowLevelDesign.Splitwise.User.User;

import java.util.List;

public class BalanceSheetController {
    public void updateUserExpenseBalanceSheet(User paidBy, List<Split> splitDetails, double expenseAmount){
        //update total amount paid of the user paidBy
        UserExpenseBalanceSheet userExpenseBalanceSheet = paidBy.getUserExpenseBalanceSheet();
        userExpenseBalanceSheet.setTotalPayment(userExpenseBalanceSheet.getTotalPayment() + expenseAmount);

        for(Split split:splitDetails){

        }
    }
}
