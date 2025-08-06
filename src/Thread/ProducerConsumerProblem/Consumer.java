package Thread.ProducerConsumerProblem;

public class Consumer implements Runnable{
    MessageQueue messageQueue;

    Consumer(MessageQueue messageQueue){
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        while (true){
            try {
                messageQueue.consume();
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
