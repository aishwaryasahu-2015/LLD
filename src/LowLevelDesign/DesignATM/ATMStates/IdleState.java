package LowLevelDesign.DesignATM.ATMStates;

import LowLevelDesign.DesignATM.ATM;
import LowLevelDesign.DesignATM.Card;

public class IdleState extends ATMState{

    @Override
    public void insertCard(ATM atm, Card card){
        System.out.println("Card Inserted");
        System.out.println("Now ATM has Card");
        atm.setCurrentAtmState(new HasCardState());
    }
}
