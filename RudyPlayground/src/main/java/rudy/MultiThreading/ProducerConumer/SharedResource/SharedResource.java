package rudy.MultiThreading.ProducerConumer.SharedResource;

public class SharedResource {

    boolean isItemAvailable = false;

    public synchronized void addItem(){
        System.out.println("Producer Thread :"+ Thread.currentThread().getName() +" called");
        isItemAvailable = true;
        notifyAll();
    }

    public synchronized void consumeItem(){
        System.out.println("Consumer Thread :"+ Thread.currentThread().getName() +" called");
        if(!isItemAvailable){
            System.out.println("Consumer Thread :"+ Thread.currentThread().getName() +" is Waiting");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        isItemAvailable = false;
        System.out.println("Consumer Thread :"+ Thread.currentThread().getName() +" consumed");
    }
}
