import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 22 Oct 2018
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/KSmallestSortedMatrix
 */

public class KSmallestSortedMatrix {

    private static class Tuple {

        int x;
        int y;
        int val;

        Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        Queue<Tuple> minHeap = new PriorityQueue<>((t1, t2) -> t1.val - t2.val);
        for (int i = 0; i < n; i++)
            minHeap.add(new Tuple(0, i, matrix[0][i]));

        for (int i = 0; i < k - 1; i++) {
            Tuple t = minHeap.poll();
            if (t.x != n - 1)
                minHeap.add(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
        }
        return minHeap.poll().val;
    }

    public static void main(String[] args) {
        KSmallestSortedMatrix obj = new KSmallestSortedMatrix();
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        System.out.println(obj.kthSmallest(matrix, 8));
    }

}
