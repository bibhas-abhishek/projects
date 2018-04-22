import java.util.Arrays;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 22 Apr 2018
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/LongestIncreasingSubsequence
 **/

public class LongestIncreasingSubsequence {

    private static int lengthOfLIS(int[] array) {
        int n = array.length;
        if (n == 0 || n == 1)
            return n;

        // dp[i] means the length of the longest subsequence till i
        int[] dp = new int[n];
        dp[0] = 1;
        int result = dp[0];
        for (int i = 1; i < n; i++) {
            int maxVal = 0;
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    maxVal = Math.max(maxVal, dp[j]);
                }
            }
            dp[i] = maxVal + 1;
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(array));
    }

}
