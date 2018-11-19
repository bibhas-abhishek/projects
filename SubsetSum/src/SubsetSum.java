/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 25 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/SubsetSum
 **/

public class SubsetSum {

    public boolean isSubsetSum(int[] set, int n, int sum) {
        if (sum == 0)
            return true;

        if (n == 0 && sum != 0)
            return false;

        if (set[n - 1] <= sum) {
            return isSubsetSum(set, n - 1, sum) || isSubsetSum(set, n - 1, sum - set[n - 1]);
        } else
            return isSubsetSum(set, n - 1, sum);
    }

    public boolean isSubsetSumDP(int[] input, int total) {
        int n = input.length;
        boolean[][] dp = new boolean[n + 1][total + 1];
        for (int row = 0; row < dp.length; row++)
            dp[row][0] = true;

        // dp[i][j] = true if sum j can be obtained with 0 -> i - 1 index elements
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= total; col++) {
                if (col < input[row - 1]) // if the current sum is less than subset element considered
                    dp[row][col] = dp[row - 1][col]; // if sum col can be obtained till row - 1 elements
                else
                    dp[row][col] = dp[row - 1][col] || dp[row - 1][col - input[row - 1]];
            }
        }
        return dp[input.length][total];
    }

    public static void main(String args[]) {
        SubsetSum obj = new SubsetSum();
        int set[] = {2, 3, 7, 8};
        int sum = 10;
        int n = set.length;
        System.out.println(obj.isSubsetSum(set, n, sum));
        System.out.println(obj.isSubsetSumDP(set, sum));
    }

}
