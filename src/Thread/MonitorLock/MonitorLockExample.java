package Thread.MonitorLock;

public class MonitorLockExample {
    public synchronized void task1(){
        try{
            System.out.println("inside task1");
            Thread.sleep(10000);
            System.out.println("After sleep code segment");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void task2(){
        System.out.println("task2, before synchronized");
        synchronized (this){
            System.out.println("task2, after synchronized");
        }
    }

    public void task3(){
        System.out.println("task3");
    }
}
