/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 23 Jun 2018
 * https://leetcode.com/problems/house-robber-ii/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/HouseRobberII
 **/

public class HouseRobberII {

    private static int rob(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return n == 1 ? nums[0] : 0;
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }

    private static int rob(int[] nums, int l, int r) {
        int curMinus1 = 0, curMinus2 = 0;
        for (int i = l; i <= r; i++) {
            int cur = Math.max(nums[i] + curMinus2, curMinus1);
            curMinus2 = curMinus1;
            curMinus1 = cur;
        }
        return curMinus1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob(nums));
    }

}
