package Thread.ProducerConsumerProblem;

import java.util.Objects;
import java.util.Scanner;

public class Producer implements Runnable{
    MessageQueue messageQueue;

    Producer(MessageQueue messageQueue){
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while(true){
            try {
                System.out.println("Type Message to Produce. Type 'exit' to quit.");
                String input = scanner.nextLine();
                if(Objects.equals(input, "exit")) {
                    System.out.println("Stopping producer....");
                    break;
                }
                messageQueue.produce(input);
            } catch (InterruptedException e) {
                System.out.println("In producer interruption block");
                Thread.currentThread().interrupt();
                break;
            }
        }

        scanner.close();
    }
}
