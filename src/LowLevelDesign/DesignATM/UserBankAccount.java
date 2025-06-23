package LowLevelDesign.DesignATM;

public class UserBankAccount {
    String name;
    String account_no;
    String ifsc;
    String branch_name;
    int balance;

    public void withdrawBalance(int amount){
        balance = balance - amount;
    }
}
