package rudy.MultiThreading.ProducerConumer.WorkWith2Thread;

public class Printer {

    public static void main(String[] args) {
        int n = 20;
        PrintEvenOdd printer = new PrintEvenOdd(n);
        Thread even = new Thread(()-> {
            try {
                printer.printEven();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "EvenThread");

        Thread odd = new Thread(()-> {
            try {
                printer.printOdd();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "OddThread");

        even.start();
        odd.start();
    }
}
