import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        Deque<Integer> dQueue = new LinkedList<>();
        if (n == 0) {
            return new int[] {};
        }

        int[] result = new int[n - k + 1];
        int index = 0;
        int i;
        for (i = 0; i < k; i++) {
            while (!dQueue.isEmpty() && arr[i] > arr[dQueue.peekLast()]) {
                dQueue.removeLast();
            }
            dQueue.addLast(i);
        }

        while (i < n) {
            result[index++] = arr[dQueue.peek()];
            while (!dQueue.isEmpty() && dQueue.peek() <= i - k) {
                dQueue.removeFirst();
            }

            while (!dQueue.isEmpty() && arr[i] > arr[dQueue.peekLast()]) {
                dQueue.removeLast();
            }
            dQueue.addLast(i);
            i++;
        }
        result[index++] = arr[dQueue.peek()];
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 12, 1, 78, 90, 57, 89, 56 };
        int k = 3;
        SlidingWindowMaximum driver = new SlidingWindowMaximum();
        int[] result = driver.maxSlidingWindow(arr, k);
        System.out.println(Arrays.toString(result));
    }
}
