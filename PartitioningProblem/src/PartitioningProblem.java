/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 18 Sep 2018
 * https://www.geeksforgeeks.org/partition-problem-dp-18/
 * https://github.com/bibhas-abhishek/projects/tree/master/PartitioningProblem
 */

public class PartitioningProblem {

    private static boolean findPartition(int[] arr, int n, boolean isDP) {
        int sum = 0;
        for (int i : arr)
            sum += i;

        if (sum % 2 != 0)
            return false;

        return isDP ? isSubsetSumDP(arr, n, sum) : isSubsetSumNaive(arr, n, sum);
    }

    private static boolean isSubsetSumNaive(int[] arr, int n, int sum) {
        if (sum == 0)
            return true;

        if (n == 0 && sum != 0)
            return false;

        if (arr[n - 1] > sum)
            return isSubsetSumNaive(arr, n - 1, sum);

        return isSubsetSumNaive(arr, n - 1, sum - arr[n - 1]) || isSubsetSumNaive(arr, n - 1, sum);
    }

    private static boolean isSubsetSumDP(int arr[], int n, int sum) {
        // dp[i][j] -> if sum j can be made with elements in the set with index 0 -> i
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = true; // can make sum with an empty set

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j < arr[i - 1]) // if sum is less than the subset element
                    dp[i][j] = dp[i - 1][j]; // if sum is less than the current subset element
                else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]]; // if the sum - arr[i-1] can be made from previous i-1 elements
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int arr[] = {3, 1, 5, 9, 12};
        System.out.println(findPartition(arr, arr.length, true));
    }

}
