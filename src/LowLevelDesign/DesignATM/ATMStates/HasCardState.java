package LowLevelDesign.DesignATM.ATMStates;

import LowLevelDesign.DesignATM.ATM;
import LowLevelDesign.DesignATM.Card;

public class HasCardState extends ATMState{

    @Override
    public void authenticatePin(ATM atm, Card card, int pin){
        System.out.println("Pin Authenticated");
        if(card.getPIN_NUMBER() != pin){
            System.out.println("Not a valid pin number exiting the transaction");
            exit(atm);
        }
        System.out.println("Now State Changes To SelectOperationState.");
        atm.setCurrentAtmState(new SelectOperationState());
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
