/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 22 Apr 2018
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/LongestIncreasingSubsequence
 **/

public class LongestIncSubsequence {

    public int longestIncreasingSubsequence(int[] array) {
        int n = array.length;
        if (n == 0 || n == 1) {
            return n;
        }

        int[] dp = new int[n];
        dp[0] = 1;
        int result = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = { 3, 4, -1, 0, 6, 2, 3 };
        System.out.println(new LongestIncSubsequence().longestIncreasingSubsequence(array));
    }
}
