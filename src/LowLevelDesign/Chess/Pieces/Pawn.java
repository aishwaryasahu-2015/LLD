package LowLevelDesign.Chess.Pieces;

import LowLevelDesign.Chess.Grid;

public class Pawn extends Piece {
    @Override
    public void move(Grid start, Grid end) {
        if(end.piece != null){
            if((end.y == start.y + 1) && (start.x == end.x + 1 || start.x == end.x-1)){
                end.piece = start.piece;
                start.piece = null;
            }
        }else{
            if((start.x==end.x) && (end.y==start.y+1)){
                end.piece = start.piece;
                start.piece = null;
            }
        }
    }
}
