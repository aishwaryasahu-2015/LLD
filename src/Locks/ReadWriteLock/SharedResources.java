package Locks.ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;

public class SharedResources {
    boolean isAvailable = false;

    public void producer(ReadWriteLock lock){
        try{
            lock.readLock().lock();
            System.out.println("Read Lock Acquired for the Thread: " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(4000);
        } catch (Exception e) {
           //do something
        }

        finally {
            System.out.println("Read Lock released for the Thread: " + Thread.currentThread().getName());
            lock.readLock().unlock();
        }
    }

    public void consumer(ReadWriteLock lock){
        try{
            lock.writeLock().lock();
            System.out.println("Write Lock Acquired for the Thread: " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(3000);
        }catch (Exception e){
            //do something
        }

        finally {
            System.out.println("Write Lock released for the Thread: " + Thread.currentThread().getName());
            lock.writeLock().unlock();
        }
    }
}
