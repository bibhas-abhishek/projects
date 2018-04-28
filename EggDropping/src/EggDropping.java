import java.util.HashMap;
import java.util.Map;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
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
    private static int eggDrop(int n, int k) {
        if (k == 0 || k == 1)
            return k;

        if (n == 1)
            return k;

        String key = n + "-" + k;

        if (map.containsKey(key))
            return map.get(key);

        int result = Integer.MAX_VALUE;
        for (int floor = 1; floor <= k; floor++) {
            int drops = Math.max(eggDrop(n - 1, floor - 1), eggDrop(n, k - floor));
            result = Math.min(result, drops);
        }
        map.put(key, result + 1);
        return result + 1;
    }

    private static int eggDropDP(int eggs, int floors) {
        if (floors == 0 || floors == 1)
            return floors;

        int[][] dp = new int[eggs + 1][floors + 1];
        for (int i = 0; i <= floors; i++)
            dp[1][i] = i;

        int result = 0;
        for (int e = 2; e <= eggs; e++) {
            for (int f = 1; f <= floors; f++) {
                dp[e][f] = Integer.MAX_VALUE;
                for (int k = 1; k <= f; k++) {
                    result = 1 + Math.max(dp[e - 1][k - 1], dp[e][f - k]);
                    dp[e][f] = Math.min(result, dp[e][f]);
                }
            }
        }
        return dp[eggs][floors];
    }

    public static void main(String[] args) {
        System.out.println(eggDrop(2, 100));
        System.out.println(eggDropDP(2, 100));
    }

}
