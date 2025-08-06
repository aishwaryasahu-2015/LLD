import java.util.ArrayList;

public class ListThreading {
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<12;i++){
            list.add(i);
        }
        Runnable listRunnable1 = new CustomeRunnable1(list);
        Runnable listRunnable2 = new CustomeRunnable2(list);
        Thread thread1 = new Thread(listRunnable1);
        Thread thread2 = new Thread(listRunnable2);
        System.out.println(thread1.getName());
        System.out.println(thread2.getName());

        thread1.run();
        thread2.run();
    }
}


