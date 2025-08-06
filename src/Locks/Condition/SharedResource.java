package Locks.Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    boolean isAvailable = false;
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void producer(){
        try{
            lock.lock();
            System.out.println("Lock acquired by the Thread: " + Thread.currentThread().getName());
            if(isAvailable){
                System.out.println("Producer Thread is waiting for resource to get consumed " + Thread.currentThread().getName());
                condition.await();
            }
            isAvailable = true;
            condition.signal();
        } catch (InterruptedException e) {
            //do something
        }

        finally {
            lock.unlock();
            System.out.println("Lock is released by the producer thread: " + Thread.currentThread().getName());
        }
    }

    public void consumer(){
        try{
            Thread.sleep(2000);
            lock.lock();
            System.out.println("Consumer Lock acquired by thread: " + Thread.currentThread().getName());
            if(!isAvailable){
                System.out.println("Consumer Thread" + Thread.currentThread().getName() + " is waiting for resource to be available");
                condition.await();
            }
            isAvailable = false;
            condition.signal();
        } catch (Exception e) {
            //Do something
        }

        finally {
            lock.unlock();
            System.out.println("Lock is released by the consumer thread: " + Thread.currentThread().getName());
        }
    }
}
