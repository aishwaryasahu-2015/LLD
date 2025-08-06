package Thread.ProducerConsumerProblem;

import java.util.LinkedList;
import java.util.Queue;

public class MessageQueue {
    private final Queue<String> queue;
    private final int capacity;

    MessageQueue(int capacity){
        this.queue = new LinkedList<>();
        this.capacity = capacity;
    }

    synchronized public void produce(String message) throws InterruptedException {
        while(queue.size() == capacity){
            System.out.println("Cannot produce message as queue hits its limit");
            wait();
        }

        queue.add(message);
        System.out.println("Message is produced: " + message);
        notifyAll();
    }

    synchronized public String consume() throws InterruptedException {
        while(queue.isEmpty()){
            System.out.println("Cannot consume message as queue as it is empty.");
            wait();
        }

        String message = this.queue.poll();
        System.out.println("Message is consumed: " + message);
        notifyAll();
        return message;
    }
}
