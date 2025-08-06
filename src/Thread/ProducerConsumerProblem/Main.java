package Thread.ProducerConsumerProblem;

public class Main {
    public static void main(String[] args){
        MessageQueue messageQueue = new MessageQueue(10);

        Thread producerThread = new Thread(new Producer(messageQueue));
        Thread consumerThread = new Thread(new Consumer(messageQueue));

        producerThread.start();
        consumerThread.start();
    }
}
