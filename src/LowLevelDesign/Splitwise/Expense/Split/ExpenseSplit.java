package LowLevelDesign.Splitwise.Expense.Split;

import java.util.List;

public interface ExpenseSplit {
    public void validate(List<Split> splitDeatils, double amount);
}
