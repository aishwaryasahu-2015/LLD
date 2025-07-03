package LLDInterview.SnakeAndLadder.SnakeAndLadder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    List<Board> gameBoard;
    Map<Integer,Integer> playerBoardPositions;
    List<Player> playerList;
    DiceFactory diceFactory;
    int playerTurn;
    int totalNumberPlayers;
    Dice dice;
    GameStatus status;
    BoardFactory boardFactory;
    int winnerPlayerId;

    public Game(DiceType diceType){
        diceFactory = new DiceFactory();
        boardFactory = new BoardFactory();
        playerList = new ArrayList<>();
        playerBoardPositions = new HashMap<>();
           this.dice = diceFactory.createDice(diceType);
           if(dice == null){
               endGame();
           }
           gameBoard = boardFactory.createBoard();
    }

    public void startGame(){
        totalNumberPlayers = playerList.size();
        playerTurn = 1;
        status = GameStatus.ACTIVE;
    }

    public void addPlayer(Player player){
        if(status == GameStatus.ACTIVE){
            System.out.println("Cannot add player in active game");
            return;
        }
        playerList.add(player);
        playerBoardPositions.put(player.id,0);
    }

    public int rollDice(){
        return dice.rollDice();
    }

    public void endGame(){
        status = GameStatus.IN_ACTIVE;
    }
}
