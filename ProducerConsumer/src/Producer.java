import java.util.concurrent.BlockingQueue;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 09 Aug 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/ProducerConsumer
 */

class Producer implements Runnable {

    private final BlockingQueue<Integer> blockingQueue;

    public Producer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("Produced: " + i);
                blockingQueue.put(i);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
    }

}
