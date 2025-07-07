package LowLevelDesign.Splitwise.Group;

import LowLevelDesign.Splitwise.Expense.Expense;
import LowLevelDesign.Splitwise.Expense.ExpenseController;
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

    List<User> userList;
    List<Expense> expenseList;
    ExpenseController expenseController;

    public Group(){
        this.userList = new ArrayList<>();
        this.expenseList = new ArrayList<>();
        this.expenseController = new ExpenseController();
    }

    public void addUser(User user){
        this.userList.add(user);
    }

    public void addExpense(Expense expense){
        this.expenseList.add(expense);
    }
}
