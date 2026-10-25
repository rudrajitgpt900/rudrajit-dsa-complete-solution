package rudy.MultiThreading.Basics;

public class MonitorLockTest {
    public static void main(String[] args) {
        System.out.println("Main thread started: "+ Thread.currentThread().getName());

        MonitorLockExample monitorLock = new MonitorLockExample();
        Thread t1 = new Thread(monitorLock::task1,"thread-1" );
        Thread t2 = new Thread(monitorLock::task2,"thread-2" );
        Thread t3 = new Thread(monitorLock::task3,"thread-3" );

        t1.start();
        t2.start();
        t3.start();
        System.out.println("Main thread finished: "+ Thread.currentThread().getName());

    }
}
