package LLDInterview.SnakeAndLadder.SnakeAndLadder;

public class DiceFactory {
    DiceType diceType;
    Dice dice;

    public Dice createDice(DiceType diceType){
        Dice diceCreated;
        switch (diceType){
            case NORMAL:
                diceCreated = new Normal();
                break;
            case CROOKED:
                diceCreated = new Crooked();
                break;
            default:
                System.out.println("Please provide a valid Dice Type");
                diceCreated = null;
                break;
        }
        dice = diceCreated;
        this.diceType = diceType;
        return diceCreated;
    }
}
