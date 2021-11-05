/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- projects: CoinChange
*- 06 Nov 2021 12:49 AM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
* https://www.geeksforgeeks.org/coin-change-dp-7/
-------------------------------------------*/

import java.util.HashMap;
import java.util.Map;

public class CoinChange {

    public int coinChangeMEM(int[] coins, int amount) {
        return coinChangeMEM(coins, amount, 0, new HashMap<>());
    }

    private int coinChangeMEM(int[] coins, int remAmt, int index, Map<String, Integer> memo) {
        if (remAmt == 0) {
            return 1;
        }

        if (index >= coins.length) {
            return 0;
        }

        String key = remAmt + "-" + index;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int include = 0;
        if (coins[index] <= remAmt) {
            include = coinChangeMEM(coins, remAmt - coins[index], index, memo);
        }

        int exclude = coinChangeMEM(coins, remAmt, index + 1, memo);
        int ways = include + exclude;
        memo.put(key, ways);
        return ways;
    }

    public int coinChangeTAB(int[] denominations, int total) {
        int n = denominations.length;
        int[][] dp = new int[n][total + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int t = 1; t <= total; t++) {
                if (i > 0) {
                    dp[i][t] = dp[i - 1][t];
                }
                if (t >= denominations[i]) {
                    dp[i][t] += dp[i][t - denominations[i]];
                }
            }
        }
        return dp[n - 1][total];
    }

    public static void main(String[] args) {
        int[] coins = new int[] { 1, 2, 3 };
        CoinChange driver = new CoinChange();
        System.out.println(driver.coinChangeMEM(coins, 5));
    }
}
