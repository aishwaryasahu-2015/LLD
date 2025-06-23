package LowLevelDesign.DesignATM.ATMStates;

import LowLevelDesign.DesignATM.ATM;
import LowLevelDesign.DesignATM.Card;
import LowLevelDesign.DesignATM.TransactionType;

public class SelectOperationState extends ATMState{

    public void selectOperations(ATM atm, Card card, TransactionType transactionType){
        System.out.println("Please select operation to proceed.");
        System.out.println("Selection Made by user: " + transactionType);

        switch (transactionType){
            case CASH_WITHDRAWAL:
                atm.setCurrentAtmState(new CashWithdrawalState());
                break;
            case BALANCE_CHECK:
                atm.setCurrentAtmState(new CheckBalanceState());
                break;
            default: {
                System.out.println("Invalid Choice");
                exit(atm);
            }
        }
    }

    public void exit(ATM atm){

    }

    public void removeCard(){
        System.out.println("The Transaction has been halted. Please remove Card");
    }
}
