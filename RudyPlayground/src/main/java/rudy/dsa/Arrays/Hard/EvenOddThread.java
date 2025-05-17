package rudy.dsa.Arrays.Hard;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class EvenOddThread {

    public static final Object object = new Object();

    public static IntPredicate even = e->e%2==0;
    public static IntPredicate odd = o-> o%2!=0;

    public static void printNumber(int i){
        synchronized (object){
            try {
                System.out.println(Thread.currentThread().getName()+" :"+i);
                object.notify();
                object.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void execute(IntPredicate condition){
        IntStream.rangeClosed(1,10).filter(condition).forEach(EvenOddThread::printNumber);
    }

    public static void main(String[] args) {
        try {
            CompletableFuture.runAsync(()->execute(odd));
            CompletableFuture.runAsync(()->execute(even));
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
