import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 02 Apr 2018
 * https://www.hackerrank.com/challenges/find-the-running-median/problem
 * https://leetcode.com/problems/find-median-from-data-stream/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/RunningMedian
 **/

public class RunningMedian {

    private static Queue<Integer> minHeap = new PriorityQueue<>();
    private static Queue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public static void main(String[] args) {

    }

    private static void addNum(int num) {
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
        // maxHeap will never be smaller than minHeap
    }

    private static double findMedian() {
        if (maxHeap.isEmpty())
            return -1;
        else if (maxHeap.size() == minHeap.size())
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        else
            return maxHeap.peek();
    }

}
