package LowLevelDesign.DesignATM.CashWithdrawal;

import LowLevelDesign.DesignATM.ATM;

public class TwoThousandWithdrawalProcessor extends CashWithdrawalProcessor{

    public TwoThousandWithdrawalProcessor(CashWithdrawalProcessor nextCashWithdrawalProcessor){
        super(nextCashWithdrawalProcessor);
    }

    public void withdraw(ATM atm, int remainingAmount){
        int required = remainingAmount / 2000;
        int balance = remainingAmount % 2000;

        if(required <= atm.getNoOfTwoThousandNotes()){
            atm.deductTwoThousandNotes(required);
            System.out.println("Number of Two Thousand Notes withdrawn: " + required);
        }else{
            balance = balance + (required - atm.getNoOfTwoThousandNotes())*2000;
            System.out.println("Number of Two Thousand Notes withdrawn: " + atm.getNoOfTwoThousandNotes());
            atm.deductTwoThousandNotes(atm.getNoOfTwoThousandNotes());
        }

        if(balance !=0 ){
            super.withdraw(atm, balance);
        }
    }
}
