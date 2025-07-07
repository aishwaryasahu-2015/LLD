package LowLevelDesign.Splitwise.Expense;

import LowLevelDesign.Splitwise.BalanceSheetController;
import LowLevelDesign.Splitwise.Expense.Split.ExpenseSplit;
import LowLevelDesign.Splitwise.Expense.Split.Split;
import LowLevelDesign.Splitwise.User.User;

import java.util.List;

public class ExpenseController {
    BalanceSheetController balanceSheetController;

    public ExpenseController(){
        this.balanceSheetController = new BalanceSheetController();
    }

    public Expense createExpense(String expenseId, String description, double expenseAmount,
                                 User paidBy, ExpenseSplitType splitType, List<Split> spiltDetails){
        ExpenseSplit expenseSplit = SplitFactory.getSplitObject(splitType);
        expenseSplit.validate(spiltDetails, expenseAmount);

        Expense expense = new Expense(expenseId, description, expenseAmount, paidBy, splitType, spiltDetails);
        balanceSheetController.updateUserExpenseBalanceSheet(paidBy, spiltDetails, expenseAmount);
        return expense;

    }
}
