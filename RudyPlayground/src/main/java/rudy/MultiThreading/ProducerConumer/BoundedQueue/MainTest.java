package rudy.MultiThreading.ProducerConumer.BoundedQueue;

public class MainTest {

    public static void main(String[] args) {
        Buffer buffer = new Buffer(3);
        Thread producerThread = new Thread(()->{
            for(int i =1; i<=6; i++){
                buffer.addItem(i);
            }
        }, "producerThread");
        Thread consumerThread = new Thread(()->{
            for(int i =1; i<=6; i++){
              var item =  buffer.consumeItem();
                System.out.println("Item consumed :: "+ item);
            }
        }, "consumerThread");

        producerThread.start();
        consumerThread.start();
    }
}
