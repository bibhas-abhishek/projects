/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 21 Sep 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/MaximumSumSubsequence
 */

public class MaxSumIncSubsequence {

    private static int maxSum(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        int result = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            dp[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 101, 2, 3, 100, 4, 5 };
        System.out.println(maxSum(arr));
    }
}
