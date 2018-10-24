import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 22 Oct 2018
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/KPairsSmallestSums
 */

public class KPairsSmallestSums {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0)
            return result;

        Queue<int[]> minHeap = new PriorityQueue<>((n1, n2) -> ((n1[0] + n1[1]) - (n2[0] + n2[1])));
        for (int i = 0; i < nums1.length && i < k; i++)
            minHeap.offer(new int[]{nums1[i], nums2[0], 0});

        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] t = minHeap.poll();
            result.add(new int[]{t[0], t[1]});
            if (t[2] != nums2.length - 1)
                minHeap.add(new int[]{t[0], nums2[t[2] + 1], t[2] + 1});
        }
        return result;
    }

    public static void main(String[] args) {
        KPairsSmallestSums obj = new KPairsSmallestSums();
        int[] nums1 = {1, 7, 11}, nums2 = {2, 4, 6};
        int k = 3;
        List<int[]> result = obj.kSmallestPairs(nums1, nums2, k);
        for (int[] e : result)
            System.out.print("[" + e[0] + "," + e[1] + "] ");
    }

}
