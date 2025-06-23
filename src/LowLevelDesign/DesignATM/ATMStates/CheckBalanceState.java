package LowLevelDesign.DesignATM.ATMStates;

import LowLevelDesign.DesignATM.ATM;
import LowLevelDesign.DesignATM.Card;

public class CheckBalanceState extends ATMState{

    @Override
    public void displayBalance(ATM atm, Card card){
        System.out.println("Balance: " + card.getBankBalance());
    }

    @Override
    public void exit(ATM atm) {
        removeCard();
        atm.setCurrentAtmState(new IdleState());
    }

    @Override
    public void removeCard(){
        System.out.println("The Transaction has been halted. Please remove Card");
    }
}
