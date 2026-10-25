package rudy.MultiThreading.Basics;

public class MonitorLockExample {

    public synchronized void task1(){
        try {
            System.out.println("task1 executed by :"+Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("Waking up :"+Thread.currentThread().getName());
        }
        catch (Exception e){
            System.out.println("caught Exception by "+ Thread.currentThread().getName());
        }
    }

    public void task2(){
        System.out.println("Task2 b4 synchronized");
        synchronized (this){
            try {
                System.out.println("task2 executed by :"+Thread.currentThread().getName());
            }
            catch (Exception e){
                System.out.println("caught Exception by "+ Thread.currentThread().getName());
            }
        }
    }

    public void task3(){
        System.out.println("task3 executed by :"+Thread.currentThread().getName());
    }
}
