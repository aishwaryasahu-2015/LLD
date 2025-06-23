package LowLevelDesign.DesignATM.CashWithdrawal;

import LowLevelDesign.DesignATM.ATM;

public class OneHundredWithdrawalProcessor extends CashWithdrawalProcessor{

    public OneHundredWithdrawalProcessor(CashWithdrawalProcessor nextCashWithdrawalProcessor){
        super(nextCashWithdrawalProcessor);
    }

    public void withdraw(ATM atm, int remainingAmount){
        int required = remainingAmount/100;
        int balance = remainingAmount % 100;

        if(required <= atm.getNoOfOneHundredNotes()){
            atm.deductOneHundredNotes(required);
            System.out.println("Number of One Hundred Notes withdrawn: " + required);
        }else {
            balance = balance + (required - atm.getNoOfOneHundredNotes())*100;
            System.out.println("Number of One Hundred Notes withdrawn: " + atm.getNoOfFiveHundredNotes());
            atm.deductOneHundredNotes(atm.getNoOfOneHundredNotes());
        }

        if(balance != 0){
            System.out.println("Something is wrong");
        }
    }
}
