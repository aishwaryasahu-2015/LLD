package Thread.ProducerConsumer;

public class Main {
    public static void main(String[] args){
        System.out.println("Main Method started");
        SharedResource sharedResource = new SharedResource();

        //Producer Thread
        Thread producerThread = new Thread(new ProduceTask(sharedResource));
        Thread consumerThread = new Thread(new ConsumeTask(sharedResource));

        producerThread.start();
        consumerThread.start();

        System.out.println("Main Method end");
    }
}
