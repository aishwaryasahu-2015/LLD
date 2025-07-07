package LowLevelDesign.Splitwise.Expense;

import LowLevelDesign.Splitwise.Expense.Split.EqualExpenseSplit;
import LowLevelDesign.Splitwise.Expense.Split.ExpenseSplit;
import LowLevelDesign.Splitwise.Expense.Split.PercentageExpenseSplit;
import LowLevelDesign.Splitwise.Expense.Split.UnequalExpenseSplit;

public class SplitFactory {
    public static ExpenseSplit getSplitObject(ExpenseSplitType splitType){
        switch (splitType){
            case EQUAL:
                return new EqualExpenseSplit();
            case UNEQUAL:
                return new UnequalExpenseSplit();
            case PERCENTAGE:
                return new PercentageExpenseSplit();
            default:
                return null;
        }
    }
}
