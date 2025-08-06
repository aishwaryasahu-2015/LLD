package Thread.ProducerConsumer;

public class ProduceTask implements Runnable{
    SharedResource sharedResource;

    ProduceTask(SharedResource sharedResource){
        this.sharedResource = sharedResource;
    }

    @Override
    public void run(){
        System.out.println("Producer Thread: " + Thread.currentThread().getName());
        try{
            Thread.sleep(5000L);
        } catch (Exception e){
            //do something
        }
        sharedResource.addItem();
    }
}
