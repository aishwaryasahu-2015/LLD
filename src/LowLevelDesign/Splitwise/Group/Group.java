package LowLevelDesign.Splitwise.Group;

import LowLevelDesign.Splitwise.Expense.Expense;
import LowLevelDesign.Splitwise.Expense.ExpenseController;
import LowLevelDesign.Splitwise.Expense.ExpenseSplitType;
import LowLevelDesign.Splitwise.Expense.Split.Split;
import LowLevelDesign.Splitwise.User.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Group {
    @Getter
    @Setter
    String groupId;

    @Getter
    @Setter
    String groupName;

    List<User> groupMembers;
    List<Expense> expenseList;
    ExpenseController expenseController;

    public Group(){
        this.groupMembers = new ArrayList<>();
        this.expenseList = new ArrayList<>();
        this.expenseController = new ExpenseController();
    }

    //add member to group
    public void addMember(User member){
        groupMembers.add(member);
    }


    public void addUser(User user){
        this.groupMembers.add(user);
    }

    public void addExpense(Expense expense){
        this.expenseList.add(expense);
    }

    public Expense createExpense(String description, double expenseAmount,
                                 List<Split> splitDetails, ExpenseSplitType splitType, User paidByUser) {
        Expense expense = expenseController.createExpense(description, expenseAmount, paidByUser, splitType, splitDetails);
        expenseList.add(expense);
        return expense;
    }

}
