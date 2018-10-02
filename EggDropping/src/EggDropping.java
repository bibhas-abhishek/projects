import java.util.HashMap;
import java.util.Map;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 25 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/EggDropping
 **/

public class EggDropping {

    private static Map<String, Integer> map = new HashMap<>();

    /**
     * @param n -> eggs
     * @param k -> floors
     * @return
     */
    private static int eggDropTopDown(int n, int k) {
        if (k == 0 || k == 1)
            return k;

        if (n == 1)
            return k;

        String key = n + "-" + k;

        if (map.containsKey(key))
            return map.get(key);

        int result = Integer.MAX_VALUE;
        for (int floor = 1; floor <= k; floor++) {
            int drops = 1 + Math.max(eggDropTopDown(n - 1, floor - 1), eggDropTopDown(n, k - floor));
            result = Math.min(result, drops);
        }
        map.put(key, result);
        return result;
    }

    private static int eggDropBottomUp(int eggs, int floors) {
        if (floors == 0 || floors == 1)
            return floors;

        int[][] dp = new int[eggs + 1][floors + 1];
        for (int i = 0; i <= floors; i++)
            dp[1][i] = i;

        int drops;
        for (int i = 2; i <= eggs; i++) {
            for (int j = 1; j <= floors; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 1; k <= j; k++) { // k -> current floor
                    drops = 1 + Math.max(dp[i - 1][k - 1], dp[i][j - k]);
                    dp[i][j] = Math.min(drops, dp[i][j]);
                }
            }
        }
        return dp[eggs][floors];
    }

    public static void main(String[] args) {
        System.out.println(eggDropTopDown(2, 100));
        System.out.println(eggDropBottomUp(2, 100));
    }

}
