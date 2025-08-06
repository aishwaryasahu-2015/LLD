import java.util.ArrayList;

public class CustomeRunnable2 implements Runnable{
    ArrayList<Integer> list;

    public CustomeRunnable2(ArrayList<Integer> list){
        this.list = list;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread());
        for(int i=0;i<list.size();i++){
            if(i%2==1){
                System.out.println("Do processing with this thread: " + Thread.currentThread().getName() + " and element: " + i);
            }
        }

    }
}
