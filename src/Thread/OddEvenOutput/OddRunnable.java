package Thread.OddEvenOutput;

import java.util.List;

public class OddRunnable implements Runnable{
    List<String> sharedList;

    OddRunnable(List<String> sharedList){
        this.sharedList = sharedList;
    }

    @Override
    public void run() {
        try {
            for(int i=0;i<sharedList.size(); i+=2){
                System.out.println("Index: " + i + " Element: " + sharedList.get(i));
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
