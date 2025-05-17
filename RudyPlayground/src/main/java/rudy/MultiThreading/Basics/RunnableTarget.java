package rudy.MultiThreading.Basics;

public class RunnableTarget implements Runnable{
    @Override
    public void run() {
        System.out.println("Run method executed by "+ Thread.currentThread().getName());
    }
}
