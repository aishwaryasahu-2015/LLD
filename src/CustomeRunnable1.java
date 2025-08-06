import java.util.ArrayList;

public class CustomeRunnable1 implements Runnable{
    ArrayList<Integer> list;
    
    public CustomeRunnable1(ArrayList<Integer> list){
        this.list = list;
    }

    @Override
    public void run() {
        for(int i=0;i<list.size();i++){
            if(i%2==0){
                System.out.println("Do processing with this thread: " + Thread.currentThread().getName() + " and element: " + i);
            }
        }

    }
}
