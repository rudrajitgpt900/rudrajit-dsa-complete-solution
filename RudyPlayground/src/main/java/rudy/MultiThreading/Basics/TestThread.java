package rudy.MultiThreading.Basics;

import rudy.MultiThreading.Basics.Customthread;

public class TestThread {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread running "+ Thread.currentThread().getName());

       Customthread thread = new Customthread();
        thread.start();
       // thread.join();
        System.out.println("Execution completed by "+ Thread.currentThread().getName());
    }
}
