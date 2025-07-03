package LLDInterview.SnakeAndLadder.SnakeAndLadder;

import java.util.ArrayList;
import java.util.Random;

public class Crooked extends Dice{

    public Crooked(){
        faces = new ArrayList<>();
        faces.add(new Face(1));
        faces.add(new Face(3));
        faces.add(new Face(5));
    }

    @Override
    public int rollDice(){
        Random rand = new Random();
        return 2*rand.nextInt(3) + 1;
    }
}
