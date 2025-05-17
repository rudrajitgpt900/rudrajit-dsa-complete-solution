package rudy.MultiThreading.ProducerConumer.SharedResource;

public class MainTest {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Thread producerThread = new Thread( ()->{
            System.out.println("Producer Thread "+ Thread.currentThread().getName() +" invoked and is going to sleep");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Producer Thread "+ Thread.currentThread().getName() +" WOKE UP !!!");
            sharedResource.addItem();
        });

        Thread consumerThread = new Thread( ()->{
            System.out.println("Consumer Thread "+ Thread.currentThread().getName() +" invoked");
            sharedResource.consumeItem();
        });
        producerThread.start();
        consumerThread.start();

    }
}
