import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 13 Sep 2018
 * https://leetcode.com/problems/advantage-shuffle/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/AdvantageShuffle
 */

public class AdvantageShuffle {

    private static int[] advantageCount(int[] a, int[] b) {
        int n = a.length;
        Arrays.sort(a);
        Queue<int[]> priorityQueue = new PriorityQueue<>((e1, e2) -> e2[1] - e1[1]);
        int[] result = new int[n];
        int high = n - 1, low = 0;
        for (int i = 0; i < b.length; i++)
            priorityQueue.offer(new int[]{i, b[i]}); // {index, value}

        while (!priorityQueue.isEmpty()) {
            int[] max = priorityQueue.poll();
            int index = max[0], value = max[1];
            if (a[high] > value) {
                result[index] = a[high];
                high -= 1; // a is sorted in ascending order
            } else {
                result[index] = a[low];
                low += 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15}, b = {1, 10, 4, 11};
        int result[] = advantageCount(a, b);
        Arrays.stream(result).mapToObj(i1 -> i1 + " ").forEach(System.out::print);
    }

}
