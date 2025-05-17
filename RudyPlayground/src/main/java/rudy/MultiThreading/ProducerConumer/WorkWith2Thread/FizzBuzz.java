package rudy.MultiThreading.ProducerConumer.WorkWith2Thread;

import java.util.function.IntConsumer;

public class FizzBuzz {
    private int n;
    private int current;
    public FizzBuzz(int n) {
        this.n = n;
        this.current = 1;
    }

    // printFizz.run() outputs "fizz".
    //when currentItem is divisible by 3 and not by 5 it prints fizz
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while (current<=n){
            while (current<=n && (current%3!=0 || current%5==0)){
                wait();
            }
            if(current>n)break;
            printFizz.run();
            current++;
            notifyAll();
        }

    }

    // printBuzz.run() outputs "buzz".
    // when the current item is divisible by 5 and not divisible by 3 it prints buzz
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while (current<=n){
            while (current<=n && (current%5!=0 || current%3==0)){
                wait();
            }
            if(current>n)break;
            printBuzz.run();
            current++;
            notifyAll();
        }

    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    // when currentItem is divisible by 15 it prints fizzbuzz
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (current<=n){
            while (current<=n && (current%15!=0)){
                wait();
            }
            if(current>n)break;
            printFizzBuzz.run();
            current++;
            notifyAll();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    //when current item is not divisible by 3 && not divisible by 5
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while (current<=n){
            while (current<=n && (current%3==0 || current%5==0)){
                wait();
            }
            if(current>n)break;
            printNumber.accept(current);
            current++;
            notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FizzBuzz fizzBuzz = new FizzBuzz(20);
        fizzBuzz.fizz(()-> System.out.println("fizz"));
        fizzBuzz.buzz(()-> System.out.println("buzz"));
        fizzBuzz.number(System.out::println);
        fizzBuzz.fizzbuzz(()-> System.out.println("fizzbuzz"));
        int n = 1;
        String s = String.valueOf(n);
    }

}
