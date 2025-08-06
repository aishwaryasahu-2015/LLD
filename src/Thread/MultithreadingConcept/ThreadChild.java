package Thread.MultithreadingConcept;

public class ThreadChild extends Thread{

    @Override
    public void run() {
        System.out.println("Overriding run for ThreadChild.");
    }
}
