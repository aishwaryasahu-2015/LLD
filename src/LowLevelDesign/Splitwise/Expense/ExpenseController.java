package LowLevelDesign.Splitwise.Expense;

import LowLevelDesign.Splitwise.BalanceSheetController;
import LowLevelDesign.Splitwise.Expense.Split.ExpenseSplit;
import LowLevelDesign.Splitwise.Expense.Split.Split;
import LowLevelDesign.Splitwise.User.User;

import java.util.List;
import java.util.UUID;

public class ExpenseController {
    BalanceSheetController balanceSheetController;

    public ExpenseController(){

        this.balanceSheetController = new BalanceSheetController();
    }

    public Expense createExpense(String description, double expenseAmount,
                                 User paidBy, ExpenseSplitType splitType, List<Split> spiltDetails){
        ExpenseSplit expenseSplit = SplitFactory.getSplitObject(splitType);
        expenseSplit.validateSplitRequest(spiltDetails, expenseAmount);

        Expense expense = new Expense(UUID.randomUUID().toString(), description, expenseAmount, paidBy, splitType, spiltDetails);
        balanceSheetController.updateUserExpenseBalanceSheet(paidBy, spiltDetails, expenseAmount);
        return expense;

    }
}
