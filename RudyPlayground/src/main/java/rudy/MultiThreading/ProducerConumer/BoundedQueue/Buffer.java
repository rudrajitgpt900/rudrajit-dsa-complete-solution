package rudy.MultiThreading.ProducerConumer.BoundedQueue;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
    Queue<Integer>buffer;
    int bufferSize;

    Buffer(int bufferSize){
        this.buffer= new LinkedList<>();
        this.bufferSize = bufferSize;
    }

    public synchronized void addItem(int item){
        System.out.println("Producer Thread:: "+ Thread.currentThread().getName() + " called");
        while (buffer.size() == bufferSize){
            System.out.println("Buffer is full gotta wait !!");
            try {
                wait();
            }catch (Exception e){
                //handle exception here;
            }
        }
        this.buffer.add(item);
        System.out.println("Producer Thread:: "+ Thread.currentThread().getName() + " added "+ item);
        notify();
    }

    public synchronized Integer consumeItem(){
        System.out.println("Consumer Thread:: "+ Thread.currentThread().getName() + " called");
        while (buffer.isEmpty()){
            System.out.println("Buffer is empty gotta wait !!");
            try {
                wait();
            }catch (Exception e){
                //handle exception here;
            }
        }
        var item = this.buffer.poll();
        notify();
        return item;
    }
}
