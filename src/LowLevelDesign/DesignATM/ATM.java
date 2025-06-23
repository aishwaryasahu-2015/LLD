package LowLevelDesign.DesignATM;

import LowLevelDesign.DesignATM.ATMStates.ATMState;
import LowLevelDesign.DesignATM.ATMStates.IdleState;
import lombok.Getter;
import lombok.Setter;

@Getter
public class ATM {
    private static final ATM atm = new ATM(); //singleton

    ATMState currentATMState;
    private int atmBalance;
    private int noOfTwoThousandNotes;
    private int noOfFiveHundredNotes;
    private int noOfOneHundredNotes;

    private ATM(){
    }

    public ATMState getCurrentAtmState(){
        return currentATMState;
    }

    public void setCurrentAtmState(ATMState currentATMState){
        this.currentATMState = currentATMState;
    }

    public static ATM getAtmObject(){
        atm.setCurrentAtmState(new IdleState());
        return atm;
    }

    public void setAtmBalance(int atmBalance, int noOfTwoThousandNotes, int noOfFiveHundredNotes, int noOfOneHundredNotes){
        this.atmBalance = atmBalance;
        this.noOfTwoThousandNotes = noOfTwoThousandNotes;
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
        this.noOfOneHundredNotes = noOfOneHundredNotes;
    }

    public void deductAtmBalance(int amount){
        atmBalance = atmBalance - amount;
    }

    public void deductTwoThousandNotes(int number){
        noOfTwoThousandNotes = noOfTwoThousandNotes - number;
    }

    public void deductFiveHundredNotes(int number){
        noOfFiveHundredNotes = noOfFiveHundredNotes - number;
    }

    public void deductOneHundredNotes(int number){
        noOfOneHundredNotes = noOfOneHundredNotes - number;
    }

    public void printCurrentAtmStatus(){
        System.out.println("Balance: " + atmBalance);
        System.out.println("2k Notes: " + noOfTwoThousandNotes);
        System.out.println("500 Notes: " + noOfFiveHundredNotes );
        System.out.println("100 Notes: " + noOfOneHundredNotes);

    }
}
