import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 22 Jun 2018
 * https://leetcode.com/problems/third-maximum-number/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/ThirdMaximumNumber
 **/

public class ThirdMaximumNumber {

    private static int thirdMax(int[] nums) {
        Queue<Integer> minheap = new PriorityQueue<>();
        for (int num : nums) {
            if (!minheap.contains(num)) {
                if (minheap.size() < 3)
                    minheap.offer(num);
                else if (minheap.peek() < num) {
                    minheap.poll();
                    minheap.offer(num);
                }
            }
        }

        if (minheap.size() < 3) {
            while (minheap.size() > 1)
                minheap.poll();
        }
        return minheap.poll();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(thirdMax(nums));
    }

}
