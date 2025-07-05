package LLDInterview.SnakeAndLadder;

import java.util.ArrayList;
import java.util.Random;

public class Normal extends Dice{

    public Normal(){
        faces = new ArrayList<>();
        for(int i=1;i<=6;i++){
            faces.add(new Face(i));
        }
    }

    @Override
    public int rollDice(){
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }
}
