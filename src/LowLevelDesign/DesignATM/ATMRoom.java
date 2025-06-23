package LowLevelDesign.DesignATM;

public class ATMRoom {
    ATM atm;
    User user;

    public static void main(String args[]){
        ATMRoom atmRoom = new ATMRoom();
        atmRoom.initialize();

        atmRoom.atm.printCurrentAtmStatus();
        atmRoom.atm.getCurrentAtmState().insertCard(atmRoom.atm, atmRoom.user.card);
        atmRoom.atm.getCurrentAtmState().authenticatePin(atmRoom.atm, atmRoom.user.card, 112233);
        atmRoom.atm.getCurrentAtmState().selectOperations(atmRoom.atm, atmRoom.user.card, TransactionType.CASH_WITHDRAWAL);
        atmRoom.atm.getCurrentAtmState().withdrawCash(atmRoom.atm, atmRoom.user.card, 2800);

        atmRoom.atm.getCurrentAtmState().insertCard(atmRoom.atm, atmRoom.user.card);
        atmRoom.atm.getCurrentAtmState().authenticatePin(atmRoom.atm, atmRoom.user.card, 112233);
        atmRoom.atm.getCurrentAtmState().selectOperations(atmRoom.atm, atmRoom.user.card, TransactionType.BALANCE_CHECK);
        atmRoom.atm.getCurrentAtmState().displayBalance(atmRoom.atm, atmRoom.user.card);

    }

    private void initialize(){
        //create an atm
        atm = ATM.getAtmObject();
        atm.setAtmBalance(10000, 3, 6, 10);

        //create a user
        this.user = createUser();
    }

    private User createUser(){
        User user = new User();
        user.setCard(createCard());
        return user;
    }

    private Card createCard(){
        Card card = new Card();
        card.setBankAccount(createBankAccount());
        return card;
    }

    private UserBankAccount createBankAccount(){
        UserBankAccount bankAccount = new UserBankAccount();
        bankAccount.balance = 5000;
        return bankAccount;
    }
}
