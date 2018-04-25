/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 25 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/SubsetSum
 **/

public class SubsetSum {

    private static boolean isSubsetSum(int[] set, int n, int sum) {
        if (sum == 0)
            return true;

        if (n == 0 && sum != 0)
            return false;

        if (set[n - 1] <= sum) {
            return isSubsetSum(set, n - 1, sum) || isSubsetSum(set, n - 1, sum - set[n - 1]);
        } else
            return isSubsetSum(set, n - 1, sum);
    }

    private static boolean isSubsetSumDP(int[] input, int total) {
        boolean[][] dp = new boolean[input.length + 1][total + 1];
        for (int row = 0; row < dp.length; row++)
            dp[row][0] = true;

        for (int row = 1; row <= input.length; row++) {
            for (int col = 1; col <= total; col++) {
                if (col < input[row - 1]) // if the current sum is less than subset element considered
                    dp[row][col] = dp[row - 1][col];
                else
                    dp[row][col] = dp[row - 1][col] || dp[row - 1][col - input[row - 1]];
            }
        }
        return dp[input.length][total];
    }

    public static void main(String args[]) {
        int set[] = {2, 3, 7, 8};
        int sum = 10;
        int n = set.length;
        /*if (isSubsetSum(set, n, sum) == true)
            System.out.println("Found a subset with given sum");
        else
            System.out.println("No subset with given sum");*/

        System.out.println(isSubsetSumDP(set, sum));
    }

}
