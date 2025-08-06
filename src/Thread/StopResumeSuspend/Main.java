package Thread.StopResumeSuspend;

public class Main {
    public static void main(String[] args){
        SharedResource sharedResource = new SharedResource();

        Thread thread1 = new Thread(() -> {
            System.out.println("Thread1 is calling the produce method.");
            sharedResource.produce();
        });

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                //do something
            }
            System.out.println("Thread2 is calling the produce method.");
            sharedResource.produce();
        });

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            //do something
        }

        thread1.suspend();
    }
}
