package LowLevelDesign.Splitwise.Expense;

import LowLevelDesign.Splitwise.Expense.Split.Split;
import LowLevelDesign.Splitwise.User.User;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Expense {
    String expenseId;
    String description;
    double expenseAmount;
    User paidBy;
    ExpenseSplitType splitType;
    List<Split> splitList;
}
