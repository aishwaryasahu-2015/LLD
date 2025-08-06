package Thread.StopResumeSuspend;

public class SharedResource {
    boolean isAvailable = false;

    public synchronized void produce(){
        System.out.println("Acquire Lock");
        System.out.println("Thread: " + Thread.currentThread().getName());
        isAvailable = true;

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            System.out.println("Throw some exception: " + e);
        }

        System.out.println("Release Lock");
    }
}
