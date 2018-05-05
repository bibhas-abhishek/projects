import java.util.HashSet;
import java.util.Set;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 04 May 2018
 * https://leetcode.com/problems/longest-consecutive-sequence/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/LongestConsecutiveSequence
 **/

public class LongestConsecutiveSequence {

    private static int longestConsecutive(int[] nums) {
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            int num = nums[i];
            while (set.contains(--num)) {
                count++;
                set.remove(num);
            }

            num = nums[i];
            while (set.contains(++num)) {
                count++;
                set.remove(num);
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }

}
