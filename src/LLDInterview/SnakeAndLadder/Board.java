package LLDInterview.SnakeAndLadder;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Board {
    final int boardIndex;
    @Setter
    Snake snake;
    @Setter
    Ladder ladder;

   public Board(int boardIndex){
       this.boardIndex = boardIndex;
       this.snake = null;
       this.ladder = null;
   }

   public Board(int boardIndex, Snake snake, Ladder ladder){
       this.boardIndex = boardIndex;
       this.snake = snake;
       this.ladder = ladder;
   }
}
