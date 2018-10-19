import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 19 Oct 2018
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/KLargestStream
 */

public class KLargestStream {

    private Queue<Integer> minHeap = new PriorityQueue<>();
    private int k;

    public KLargestStream(int k, int[] arr) {
        this.k = k;
        for (int n : arr)
            add(n);
    }

    public int add(int val) {
        if (minHeap.size() < k)
            minHeap.offer(val);
        else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 8, 2};
        KLargestStream obj = new KLargestStream(3, arr);
        System.out.println(obj.add(3));
        System.out.println(obj.add(5));
        System.out.println(obj.add(10));
        System.out.println(obj.add(9));
        System.out.println(obj.add(4));
    }

}
