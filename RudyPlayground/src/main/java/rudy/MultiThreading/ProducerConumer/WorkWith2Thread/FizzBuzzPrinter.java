package rudy.MultiThreading.ProducerConumer.WorkWith2Thread;

public class FizzBuzzPrinter {
    private int current = 1;
    private final int max;

    public FizzBuzzPrinter(int max) {
        this.max = max;
    }

    public synchronized void printFizz() {
        while (current <= max) {
            while (current <= max && (current % 3 != 0 || current % 5 == 0)) {
                try {
                    wait();
                }
                catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            if (current > max) break;
            System.out.println(Thread.currentThread().getName() + " -> Fizz -> "+current);
            current++;
            notifyAll();
        }
    }

    public synchronized void printBuzz() {
        while (current <= max) {
            while (current <= max && (current % 5 != 0 || current % 3 == 0)) {
                try {
                    wait();
                }
                catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            if (current > max) break;
            System.out.println(Thread.currentThread().getName() + " -> Buzz -> "+current);
            current++;
            notifyAll();
        }
    }

    // <<< NEW METHOD >>>
    public synchronized void printNumber() {
        while (current <= max) {
            // wait until current is neither fizz nor buzz
            while (current <= max && (current % 3 == 0 || current % 5 == 0)) {
                try {
                    wait();
                }
                catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            if (current > max) break;
            System.out.println(Thread.currentThread().getName() + " -> " + current);
            current++;
            notifyAll();
        }
    }
    public synchronized void printFizzBuzz() {
        while (current <= max) {
            // wait until current is neither fizz nor buzz
            while (current <= max && (current % 15 != 0)) {
                try {
                    wait();
                }
                catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            if (current > max) break;
            System.out.println(Thread.currentThread().getName() + " -> " + current);
            current++;
            notifyAll();
        }
    }
}
