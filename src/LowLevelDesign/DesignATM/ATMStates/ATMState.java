package LowLevelDesign.DesignATM.ATMStates;

import LowLevelDesign.DesignATM.ATM;
import LowLevelDesign.DesignATM.Card;
import LowLevelDesign.DesignATM.TransactionType;

public class ATMState {

    public void insertCard(ATM atm, Card card){
        System.out.println("Oops something went wrong!");
    }

    public void authenticatePin(ATM atm, Card card, int pin){
        System.out.println("Oops something went wrong!");
    }

    public void selectOperations(ATM atm, Card card, TransactionType transactionType){
        System.out.println("Oops something went wrong!");
    }

    public void withdrawCash(ATM atm, Card card, int amount){
        System.out.println("Oops something went wrong!");
    }

    public void displayBalance(ATM atm, Card card){
        System.out.println("Oops something went wrong!");
    }

    public void exit(ATM atm){
        System.out.println("Oops something went wrong!");
    }

    public void removeCard(){
        System.out.println("Oops something went wrong!");
    }

}
