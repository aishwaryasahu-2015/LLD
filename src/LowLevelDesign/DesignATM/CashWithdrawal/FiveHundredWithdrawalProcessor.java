package LowLevelDesign.DesignATM.CashWithdrawal;

import LowLevelDesign.DesignATM.ATM;

public class FiveHundredWithdrawalProcessor extends CashWithdrawalProcessor{

    public FiveHundredWithdrawalProcessor(CashWithdrawalProcessor nextCashWithdrawalProcessor){
        super(nextCashWithdrawalProcessor);
    }

    public void withdraw(ATM atm, int remainingAmount){
        int required = remainingAmount/500;
        int balance = remainingAmount%500;

        if(required <= atm.getNoOfFiveHundredNotes()){
            atm.deductFiveHundredNotes(required);
            System.out.println("Number of Five Hundred Notes withdrawn: " + required);
        }else{
            balance = balance + (required - atm.getNoOfFiveHundredNotes())*500;
            System.out.println("Number of Five Hundred Notes withdrawn: " + atm.getNoOfFiveHundredNotes());
            atm.deductFiveHundredNotes(atm.getNoOfFiveHundredNotes());
        }

        if(balance !=0 ){
            super.withdraw(atm, balance);
        }
    }
}
