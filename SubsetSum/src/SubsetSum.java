public class SubsetSum {

    public boolean isSubsetSum(int[] num, int sum) {
        int n = num.length;
        boolean[][] dp = new boolean[n][sum + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        for (int s = 1; s <= sum; s++) {
            dp[0][s] = num[0] == s;
        }

        for (int i = 1; i < n; i++) {
            for (int s = 1; s <= sum; s++) {
                if (dp[i - 1][s]) {
                    dp[i][s] = dp[i - 1][s];
                } else if (num[i] <= s) {
                    dp[i][s] = dp[i - 1][s - num[i]];
                }
            }
        }
        return dp[n - 1][sum];
    }

    public static void main(String[] args) {
        SubsetSum driver = new SubsetSum();
        int[] set = { 2, 3, 7, 8 };
        int sum = 11;
        System.out.println(driver.isSubsetSum(set, sum));
    }
}
