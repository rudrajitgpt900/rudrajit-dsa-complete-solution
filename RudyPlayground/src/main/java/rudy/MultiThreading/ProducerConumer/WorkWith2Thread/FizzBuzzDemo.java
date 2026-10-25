package rudy.MultiThreading.ProducerConumer.WorkWith2Thread;

public class FizzBuzzDemo {

    public static void main(String[] args) {
        int max = 20;
        FizzBuzzPrinter printer = new FizzBuzzPrinter(max);

        Thread fizzThread = new Thread(printer::printFizz, "Fizz-Thread");
        Thread buzzThread = new Thread(printer::printBuzz, "Buzz-Thread");
        Thread numberThread = new Thread(printer::printNumber, "Number-Thread");
        Thread fizzbuzzThread = new Thread(printer::printFizzBuzz, "FizzBuzz-Thread");

        fizzThread.start();
        buzzThread.start();
        numberThread.start();
        fizzbuzzThread.start();
    }
}
