package LowLevelDesign.Splitwise2;

// Splitwise-like Expense Sharing System - LLD Implementation

import java.util.*;

// ENUMS
enum SplitType {
    EQUAL, PERCENTAGE, UNEQUAL
}

// MODELS
class User {
    String userId;
    String name;
    String email;

    public User(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }
}

class Group {
    String groupId;
    String groupName;
    List<User> users;
    List<Expense> expenses;

    public Group(String groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.users = new ArrayList<>();
        this.expenses = new ArrayList<>();
    }
}

class Split {
    User user;
    double amount;

    public Split(User user, double amount) {
        this.user = user;
        this.amount = amount;
    }
}

class Expense {
    String expenseId;
    String description;
    double totalAmount;
    User paidBy;
    SplitType splitType;
    List<Split> splits;

    public Expense(String expenseId, String description, double totalAmount, User paidBy, SplitType splitType, List<Split> splits) {
        this.expenseId = expenseId;
        this.description = description;
        this.totalAmount = totalAmount;
        this.paidBy = paidBy;
        this.splitType = splitType;
        this.splits = splits;
    }
}

class UserExpenseBalanceSheet {
    double totalPaid;
    double totalOwe;
    double totalGetBack;
    double netExpense;

    public UserExpenseBalanceSheet() {
        this.totalPaid = 0;
        this.totalOwe = 0;
        this.totalGetBack = 0;
        this.netExpense = 0;
    }

    public void updatePaid(double amount) {
        totalPaid += amount;
        updateNet();
    }

    public void updateOwe(double amount) {
        totalOwe += amount;
        updateNet();
    }

    public void updateGetBack(double amount) {
        totalGetBack += amount;
        updateNet();
    }

    private void updateNet() {
        netExpense = totalPaid - totalOwe;
    }
}

// CONTROLLERS
class GroupController {
    Map<String, Group> groups = new HashMap<>();

    public Group createGroup(String groupId, String name) {
        Group group = new Group(groupId, name);
        groups.put(groupId, group);
        return group;
    }

    public void addUserToGroup(String groupId, User user) {
        Group group = groups.get(groupId);
        if (group != null) {
            group.users.add(user);
        }
    }
}

class UserController {
    Map<String, User> users = new HashMap<>();

    public User createUser(String userId, String name, String email) {
        User user = new User(userId, name, email);
        users.put(userId, user);
        return user;
    }

    public User getUser(String userId) {
        return users.get(userId);
    }
}

class BalanceSheetController {
    Map<String, UserExpenseBalanceSheet> balanceSheetMap = new HashMap<>();
    Map<String, Map<String, Double>> userToUserBalance = new HashMap<>();

    public void updateBalances(Expense expense) {
        String paidById = expense.paidBy.userId;
        balanceSheetMap.putIfAbsent(paidById, new UserExpenseBalanceSheet());
        balanceSheetMap.get(paidById).updatePaid(expense.totalAmount);

        userToUserBalance.putIfAbsent(paidById, new HashMap<>());

        for (Split split : expense.splits) {
            String userId = split.user.userId;
            balanceSheetMap.putIfAbsent(userId, new UserExpenseBalanceSheet());
            balanceSheetMap.get(userId).updateOwe(split.amount);
            if (!userId.equals(paidById)) {
                balanceSheetMap.get(paidById).updateGetBack(split.amount);

                userToUserBalance.putIfAbsent(userId, new HashMap<>());

                userToUserBalance.get(userId).put(paidById,
                        userToUserBalance.get(userId).getOrDefault(paidById, 0.0) + split.amount);

                userToUserBalance.get(paidById).put(userId,
                        userToUserBalance.get(paidById).getOrDefault(userId, 0.0) - split.amount);
            }
        }
    }

    public UserExpenseBalanceSheet getUserBalance(String userId) {
        return balanceSheetMap.getOrDefault(userId, new UserExpenseBalanceSheet());
    }

    public void printSettlementTransactionsForGroup(List<User> users) {
        System.out.println("\nTransactions to Settle Group:");
        Set<String> printed = new HashSet<>();
        for (User fromUser : users) {
            Map<String, Double> balances = userToUserBalance.getOrDefault(fromUser.userId, new HashMap<>());
            for (User toUser : users) {
                if (fromUser.userId.equals(toUser.userId)) continue;
                double amount = balances.getOrDefault(toUser.userId, 0.0);
                if (amount > 0 && !printed.contains(fromUser.userId + "->" + toUser.userId)) {
                    System.out.println(fromUser.name + " owes ₹" + String.format("%.2f", amount) + " to " + toUser.name);
                    printed.add(fromUser.userId + "->" + toUser.userId);
                }
            }
        }
    }
}

class ExpenseController {
    BalanceSheetController balanceSheetController;

    public ExpenseController(BalanceSheetController balanceSheetController) {
        this.balanceSheetController = balanceSheetController;
    }

    public Expense createExpense(String expenseId, String description, double totalAmount, User paidBy, SplitType splitType, List<User> users, List<Double> values) {
        List<Split> splits = new ArrayList<>();
        if (splitType == SplitType.EQUAL) {
            double share = totalAmount / users.size();
            for (User user : users) {
                splits.add(new Split(user, share));
            }
        } else if (splitType == SplitType.UNEQUAL || splitType == SplitType.PERCENTAGE) {
            for (int i = 0; i < users.size(); i++) {
                double value = (splitType == SplitType.PERCENTAGE) ? (totalAmount * values.get(i)) / 100 : values.get(i);
                splits.add(new Split(users.get(i), value));
            }
        }
        Expense expense = new Expense(expenseId, description, totalAmount, paidBy, splitType, splits);
        balanceSheetController.updateBalances(expense);
        return expense;
    }
}

class SplitwiseApp {
    Map<String, Group> groups = new HashMap<>();
    List<Expense> nonGroupExpenses = new ArrayList<>();

    GroupController groupController = new GroupController();
    UserController userController = new UserController();
    BalanceSheetController balanceSheetController = new BalanceSheetController();
    ExpenseController expenseController = new ExpenseController(balanceSheetController);

    public void addExpenseToGroup(String groupId, Expense expense) {
        Group group = groupController.groups.get(groupId);
        if (group != null) {
            group.expenses.add(expense);
        }
    }

    public void addNonGroupExpense(Expense expense) {
        nonGroupExpenses.add(expense);
    }

    public void printUserBalanceSheet(String userId) {
        UserExpenseBalanceSheet sheet = balanceSheetController.getUserBalance(userId);
        System.out.println("User ID: " + userId);
        System.out.println("Total Paid: ₹" + sheet.totalPaid);
        System.out.println("Total Owe: ₹" + sheet.totalOwe);
        System.out.println("Total Get Back: ₹" + sheet.totalGetBack);
        System.out.println("Net Expense: ₹" + sheet.netExpense);
    }

    public void printSettlementForGroup(String groupId) {
        Group group = groupController.groups.get(groupId);
        if (group != null) {
            balanceSheetController.printSettlementTransactionsForGroup(group.users);
        }
    }
}

