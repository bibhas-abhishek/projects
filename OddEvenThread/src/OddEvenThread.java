import java.util.concurrent.Semaphore;

public class OddEvenThread {

    private static class SharedPrinter {

        private final Semaphore semOdd  = new Semaphore(1);
        private final Semaphore semEven = new Semaphore(0);

        private void printOdd(int n) {
            try {
                semOdd.acquire();
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(Thread.currentThread().getName() + ": " + n);
            semEven.release();
        }

        private void printEven(int n) {
            try {
                semEven.acquire();
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(Thread.currentThread().getName() + ": " + n);
            semOdd.release();
        }
    }

    private static class OddPrinter implements Runnable {

        private final SharedPrinter sharedPrinter;
        private final int           max;

        public OddPrinter(SharedPrinter sharedPrinter, int max) {
            this.sharedPrinter = sharedPrinter;
            this.max = max;
        }

        @Override
        public void run() {
            for (int i = 1; i <= max; i += 2) {
                sharedPrinter.printOdd(i);
            }
        }
    }

    private static class EvenPrinter implements Runnable {

        private final SharedPrinter sharedPrinter;
        private final int           max;

        public EvenPrinter(SharedPrinter sharedPrinter, int max) {
            this.sharedPrinter = sharedPrinter;
            this.max = max;
        }

        @Override
        public void run() {
            for (int i = 2; i <= max; i += 2) {
                sharedPrinter.printEven(i);
            }
        }
    }

    public static void main(String[] args) {
        SharedPrinter sharedPrinter = new SharedPrinter();
        Thread oddThread = new Thread(new OddPrinter(sharedPrinter, 10), "OddThread");
        Thread evenThread = new Thread(new EvenPrinter(sharedPrinter, 10), "EvenThread");
        oddThread.start();
        evenThread.start();
    }
}
