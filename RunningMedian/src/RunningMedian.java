import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 02 Apr 2018
 * https://www.hackerrank.com/challenges/find-the-running-median/problem
 * https://leetcode.com/problems/find-median-from-data-stream/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/RunningMedian
 **/

public class RunningMedian {

    private Queue<Integer> minHeap = new PriorityQueue<>();
    private Queue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

    public int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty())
            maxHeap.add(num);
        else if (maxHeap.size() == minHeap.size()) {
            if (num < minHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
                maxHeap.add(minHeap.remove());
            }
        } else if (maxHeap.size() > minHeap.size()) {
            if (num > maxHeap.peek()) {
                minHeap.add(num);
            } else {
                maxHeap.add(num);
                minHeap.add(maxHeap.remove());
            }
        }
        // maxHeap >= minHeap
    }

    public double findMedian() {
        if (maxHeap.isEmpty())
            return -1;
        else if (maxHeap.size() == minHeap.size())
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        else
            return maxHeap.peek();
    }

    public static void main(String[] args) {
        RunningMedian obj = new RunningMedian();
        for (int i = 0; i < 1000; i++)
            obj.addNum(obj.getRandomNumberInRange(0, 1000));

        System.out.print(obj.findMedian());
    }

}
