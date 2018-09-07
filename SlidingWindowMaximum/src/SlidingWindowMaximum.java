import java.util.Deque;
import java.util.LinkedList;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 04 Sep 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/SlidingWindowMaximum
 */

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int arr[] = {12, 1, 78, 90, 57, 89, 56};
        int k = 3;
        printMax(arr, arr.length, k);
    }

    private static void printMax(int[] arr, int n, int k) {
        Deque<Integer> dQueue = new LinkedList<>();
        int i;

        // slide first k elements
        for (i = 0; i < k; i++) {
            slide(arr, dQueue, i);
        }

        // queue_rear to queue_front -> small to large
        // larger arr[i] will deque all smaller elements
        // smaller arr[i] will be added at queue rear

        while (i < n) {

            // front element is the largest element, hence print
            System.out.print(arr[dQueue.peek()] + " ");

            // peek front because old elements are pushed to the front
            // remove the front elements if they do not lie in the window
            while (!dQueue.isEmpty() && dQueue.peek() <= i - k)
                dQueue.removeFirst();

            slide(arr, dQueue, i);
            i++;
        }
        System.out.print(arr[dQueue.peek()]);
    }

    private static void slide(int[] arr, Deque<Integer> dQueue, int i) {
        while (!dQueue.isEmpty() && arr[i] > arr[dQueue.peekLast()])
            dQueue.removeLast();

        dQueue.addLast(i);
    }

}
