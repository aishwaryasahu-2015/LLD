package Thread.OddEvenOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<String> list = new ArrayList<>(Arrays.asList("a","b","c","d","e","f","g"));

        Thread oddThread = new Thread(new OddRunnable(list));
        Thread evenThread = new Thread(new EvenRunnable(list));

        oddThread.start();
        evenThread.start();
    }
}
