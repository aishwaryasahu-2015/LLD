package LowLevelDesign.DesignATM.ATMStates;

import LowLevelDesign.DesignATM.ATM;
import LowLevelDesign.DesignATM.Card;
import LowLevelDesign.DesignATM.CashWithdrawal.CashWithdrawalProcessor;
import LowLevelDesign.DesignATM.CashWithdrawal.FiveHundredWithdrawalProcessor;
import LowLevelDesign.DesignATM.CashWithdrawal.OneHundredWithdrawalProcessor;
import LowLevelDesign.DesignATM.CashWithdrawal.TwoThousandWithdrawalProcessor;

public class CashWithdrawalState extends ATMState{
    CashWithdrawalProcessor cashWithdrawalProcessor;

    @Override
    public void withdrawCash(ATM atm, Card card, int amount){
        System.out.println("Please withdraw Cash.");
        System.out.println("ATM Balance: " + atm.getAtmBalance());
        System.out.println("Bank Balance: " + card.getBankBalance());
        if(card.getBankBalance()<amount){
            System.out.println("Request Cannot be fulfilled as amount requested " +
                    "for cash withdrawal is more than the user bank balance.");
        } else if(atm.getAtmBalance()<amount){
            System.out.println("Request cannot be fulfilled as amount requested " +
                    "is more than ATM balance.");
        } else {
            card.deductBankBalance(amount);
            atm.deductAtmBalance(amount);
            CashWithdrawalProcessor withdrawalProcessor = new TwoThousandWithdrawalProcessor(
                    new FiveHundredWithdrawalProcessor(new OneHundredWithdrawalProcessor(null)));
            withdrawalProcessor.withdraw(atm, amount);
            exit(atm);
        }
    }

    @Override
    public void exit(ATM atm) {
        removeCard();
        atm.setCurrentAtmState(new IdleState());

    }

    @Override
    public void removeCard() {
        System.out.println("The Transaction has been halted. Please remove Card");
    }
}
