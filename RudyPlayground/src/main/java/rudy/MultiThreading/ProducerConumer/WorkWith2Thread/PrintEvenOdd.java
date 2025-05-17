package rudy.MultiThreading.ProducerConumer.WorkWith2Thread;

public class PrintEvenOdd {

    int n;
    int count;

    PrintEvenOdd(int n){
        this.n =n;
        this.count = 1;
    }

    public synchronized void printEven() throws InterruptedException {
        while (count<=n){
            while (count<=n && count%2==1){
                wait();
            }
            if(count>n)break;
            System.out.println(Thread.currentThread().getName() +" :: "+count);
            count+=1;
            notifyAll();
        }
    }

    public synchronized void printOdd() throws InterruptedException {
        while (count<=n){
            while (count<=n && count%2==0){
               wait();
            }
            if (count>n)break;
            System.out.println(Thread.currentThread().getName() +" :: "+count);
            count+=1;
            notifyAll();
        }
    }
}
