package LLDInterview.SnakeAndLadder.SnakeAndLadder;

import java.util.Map;

public class SnakeAndLadderGame {

    public static void main(String args[]){
        Game game = new Game(DiceType.CROOKED);//Can be DiceType.NORMAL
        game.addPlayer(new Player(1));
        game.addPlayer(new Player(2));
        game.addPlayer(new Player(3));
        game.addPlayer(new Player(4));

        game.startGame();

        int counter = 0;


        while(game.status != GameStatus.FINISHED){
            if(counter == 10){
                for (Map.Entry<Integer, Integer> entry : game.playerBoardPositions.entrySet()) {
                    System.out.println(entry.getKey() + " => " + entry.getValue());
                }
            }
            int playerTurn = game.playerTurn;
            if(playerTurn == 1)
                counter++;
            int diceScore = game.rollDice();
            System.out.println("playerTurn: " + playerTurn);
            System.out.println("diceScore: " + diceScore);

            int currentBoardIndex = game.playerBoardPositions.get(playerTurn);
            int futureBoardIndex = currentBoardIndex + diceScore;
            System.out.println("currentIndex: " + currentBoardIndex + " futureBoardIndex: " + futureBoardIndex);
            if(futureBoardIndex >= 100){
                game.status = GameStatus.FINISHED;
                game.winnerPlayerId = playerTurn;
                break;
            }
            if(game.gameBoard.get(futureBoardIndex).snake != null){
                Snake snake = game.gameBoard.get(futureBoardIndex).snake;
                futureBoardIndex = snake.endBoardIndex;
            }
            else if(game.gameBoard.get(futureBoardIndex).ladder != null){
                Ladder ladder = game.gameBoard.get(futureBoardIndex).ladder;
                futureBoardIndex = ladder.endBoardIndex;
            }
            game.playerBoardPositions.put(playerTurn, futureBoardIndex);
            game.playerTurn = (game.playerTurn + 1) % game.totalNumberPlayers ;
            game.playerTurn = (game.playerTurn == 0 ? game.totalNumberPlayers : game.playerTurn);
        }
        System.out.println("Winner is: " + game.winnerPlayerId);
    }
}
