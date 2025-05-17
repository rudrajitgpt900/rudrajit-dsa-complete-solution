package rudy.MultiThreading.Basics;

public class Customthread extends Thread{

    @Override
    public void run() {
        System.out.println("Run method executed by custom thread "+ Thread.currentThread().getName());
    }
}
