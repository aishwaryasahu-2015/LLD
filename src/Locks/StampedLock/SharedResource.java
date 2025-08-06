package Locks.StampedLock;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {
    int a = 10;
    StampedLock lock = new StampedLock();

    public void producer(){
        long stamp =  lock.tryOptimisticRead();
        try {
            System.out.println("Read Lock acquired by the Thread: " + Thread.currentThread().getName() + " Lock value: " + stamp);
            a = 11;
            if(lock.validate(stamp)){
                System.out.println("Update value successfully: " + a);
            }else{
                System.out.println("Rollback of work: " + a);
                a = 10;
            }
        } catch (Exception e) {
            //Handle Exception
        }
        System.out.println("Lock value: " + stamp);
    }

    public void consumer(){
        long stamp = lock.writeLock();
        System.out.println("Write Lock acquired by the Thread: " + Thread.currentThread().getName() + " Lock value : " + stamp);

        System.out.println("performing work");
        a = 9;
        
        System.out.println("Write Lock released by the Thread: " + Thread.currentThread().getName() + " Lock value: " + stamp);
        lock.unlock(stamp);

    }
}
