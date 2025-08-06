package Thread.OddEvenOutput;

import java.util.List;

public class EvenRunnable implements Runnable{
    List<String> sharedList;

    EvenRunnable(List<String> sharedList){
        this.sharedList = sharedList;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1);
            for(int i=1;i<sharedList.size(); i+=2){
                System.out.println("Index: " + i + " element: " + sharedList.get(i));
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
