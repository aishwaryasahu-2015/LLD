package Thread.MultipleThreadJoin;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("Thread1 is running");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
                System.out.println("Thread1 ended");
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                System.out.println("Thread2 is running");
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
                System.out.println("Thread2 ended");
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                System.out.println("Thread3 is running");
                Thread.sleep(9000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
                System.out.println("Thread3 ended");
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        LinkedList<Integer> list = new LinkedList<>();

        System.out.println("All threads finished. Continuing as a single thread...");
    }
}
