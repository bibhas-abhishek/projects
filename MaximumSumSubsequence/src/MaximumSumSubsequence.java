/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 21 Sep 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/MaximumSumSubsequence
 */

public class MaximumSumSubsequence {

    private static int maxSum(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++)
            dp[i] = arr[i];

        int result = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i])
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {4, 6, 1, 3, 8, 4, 6};
        System.out.println(maxSum(arr));
    }

}
