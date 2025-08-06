package Thread.MultithreadingConcept;

public class Main {
    public static void main(String[] args){
        Multithreading runnableObj = new Multithreading(); //This is a runnable object.
        Thread thread1 = new Thread(runnableObj);
        ThreadChild threadChild = new ThreadChild();
        thread1.start();
        threadChild.start();
    }
}
