public class EggDropping {

    public int eggDropping(int eggs, int floors) {
        if (floors == 0 || floors == 1) {
            return floors;
        }

        int[][] dp = new int[eggs + 1][floors + 1];
        // 1 egg base case
        for (int i = 0; i <= floors; i++) {
            dp[1][i] = i;
        }

        int drops;
        for (int i = 2; i <= eggs; i++) {
            for (int j = 1; j <= floors; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 1; k <= j; k++) {
                    drops = 1 + Math.max(dp[i - 1][k - 1], dp[i][j - k]);
                    dp[i][j] = Math.min(drops, dp[i][j]);
                }
            }
        }
        return dp[eggs][floors];
    }

    public static void main(String[] args) {
        EggDropping driver = new EggDropping();
        System.out.println(driver.eggDropping(2, 100));
    }
}
