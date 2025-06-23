package LowLevelDesign.DesignATM;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Card {
    private int cardNumber;
    private int cvv;
    private int holderName;
    private int expiryDate;
    private int PIN_NUMBER = 112233;

    private UserBankAccount bankAccount;

    public void deductBankBalance(int withdrawalAmount){
        bankAccount.withdrawBalance(withdrawalAmount);
    }

    public int getBankBalance(){
        return bankAccount.balance;
    }
}
