import java.util.concurrent.BlockingQueue;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 09 Aug 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/ProducerConsumer
 */

class Consumer implements Runnable {

    private final BlockingQueue<Integer> blockingQueue;

    public Consumer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumed: " + blockingQueue.take());
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
    }

}
