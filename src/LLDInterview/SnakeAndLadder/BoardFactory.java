package LLDInterview.SnakeAndLadder;

import java.util.ArrayList;
import java.util.List;

public class BoardFactory {

    public List<Board> createBoard(){
        List<Board> gameBoard = new ArrayList<>(100);
        for(int i=1;i<=100;i++){
            Board board = new Board(i);
            gameBoard.add(board);
        }

        Snake snake1 = new Snake(12, 5);
        Snake snake2 = new Snake(54, 32);
        gameBoard.get(snake1.startBoardIndex-1).setSnake(snake1);
        gameBoard.get(snake2.startBoardIndex-1).setSnake(snake2);


        Ladder ladder1 = new Ladder(10, 43);
        Ladder ladder2 = new Ladder(23, 56);
        gameBoard.get(ladder1.startBoardIndex-1).setLadder(ladder1);
        gameBoard.get(ladder2.startBoardIndex-1).setLadder(ladder2);

        return gameBoard;
    }
}
