import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/description/
 **/

public class RunningMedian {

    private Queue<Integer> minHeap;
    private Queue<Integer> maxHeap;

    public RunningMedian() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }

    private int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    // add smaller half in maxHeap/ larger half in minHeap
    // maintain maxHeap.size >= minHeap.size
    public void addNum(int num) {
        if (maxHeap.isEmpty()) {
            maxHeap.add(num);
        }
        else if (maxHeap.size() > minHeap.size()) {
            if (num > maxHeap.peek()) {
                minHeap.add(num);
            }
            else {
                maxHeap.add(num);
                minHeap.add(maxHeap.remove());
            }
        }
        else if (maxHeap.size() == minHeap.size()) {
            if (num < minHeap.peek()) {
                maxHeap.add(num);
            }
            else {
                minHeap.add(num);
                maxHeap.add(minHeap.remove());
            }
        }
    }

    public double findMedian() {
        if (maxHeap.isEmpty()) {
            return -1;
        }
        else if (maxHeap.size() == minHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        RunningMedian obj = new RunningMedian();
        for (int i = 0; i < 1000; i++) {
            obj.addNum(obj.getRandomNumberInRange(0, 1000));
        }
        System.out.print(obj.findMedian());
    }
}
