import java.util.HashMap;
import java.util.Map;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 29 Sep 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/DiceThrow
 */

// given n dice, each with m faces, count the number of ways to make sum x
public class DiceThrow {

    private static int findWaysTab(int n, int m, int x) {
        int[][] dp = new int[n + 1][x + 1];

        // for one dice throw
        for (int i = 1; i <= Math.min(m, x); i++)
            dp[1][i] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= x; j++) {
                for (int k = 1; k <= m && k < j; k++) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        return dp[n][x];
    }

    private static int findWaysMem(int n, int m, int x, Map<String, Integer> memo) {
        if (n == 0 || x < 1)
            return 0;

        if (n == 1)
            return x <= m ? 1 : 0;

        String key = n + "-" + x;
        if (memo.containsKey(key))
            return memo.get(key);

        int ways = 0;
        for (int i = 1; i <= m; i++)
            ways += findWaysMem(n - 1, m, x - i, memo);

        memo.put(key, ways);
        return ways;
    }

    public static void main(String[] args) {
        System.out.println(findWaysTab(3, 6, 8));
        System.out.println(findWaysMem(3, 6, 8, new HashMap<>()));
    }

}
