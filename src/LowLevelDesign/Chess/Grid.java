package LowLevelDesign.Chess;

import LowLevelDesign.Chess.Pieces.Piece;
import lombok.Setter;

public class Grid {

    public int x;
    public int y;
    @Setter
    public Piece piece;

    public Grid(int x, int y){
        this.x = x;
        this.y = y;
        this.piece = null;
    }

    public Grid(int x, int y, Piece piece){
        this.x = x;
        this.y = y;
        this.piece = piece;
    }
}
