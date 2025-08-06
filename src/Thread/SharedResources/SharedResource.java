package Thread.SharedResources;

public class SharedResource {
    boolean isItemPresent = false;

    public synchronized void addItem(){
        isItemPresent = true;
    }

    public synchronized void consumeItem(){
        isItemPresent = false;
    }
}
