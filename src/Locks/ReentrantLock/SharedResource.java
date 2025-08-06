package Locks.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    boolean isAvailable = false;

    public void producer(ReentrantLock lock){
        try{
            lock.lock();
            System.out.println("Lock acquired by the Thread: " + Thread.currentThread().getName() + " and now we will update the isAvailable");
            isAvailable = true;
            Thread.sleep(4000);
        }catch (Exception e){
            //do something
        }

        finally{
            System.out.println("Lock released by the Thread " + Thread.currentThread().getName());
            lock.unlock();
        }
    }
}
