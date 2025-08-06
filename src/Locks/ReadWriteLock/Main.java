package Locks.ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    public static void main(String[] args){
        SharedResources resource1 = new SharedResources();
        ReadWriteLock lock1 = new ReentrantReadWriteLock();
        ReadWriteLock lock2 = new ReentrantReadWriteLock();
        ReadWriteLock lock3 = new ReentrantReadWriteLock();

        Thread th1 = new Thread(() -> {
            resource1.producer(lock1);
        });

        Thread th2 = new Thread(() -> {
            resource1.producer(lock1);
        });

        SharedResources resource2 = new SharedResources();
        Thread th3 = new Thread(() -> {
            resource2.consumer(lock2);
        });

        Thread th4 = new Thread(() -> {
            resource1.consumer(lock3);
        });


        System.out.println("Process Will Start Now.");
        th1.start();
        th2.start();
        th3.start();
        th4.start();
    }
}
