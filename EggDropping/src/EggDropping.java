import java.util.HashMap;
import java.util.Map;

public class EggDropping {

    private static Map<String, Integer> map = new HashMap<>();

    private static int eggDropDPMemo(int eggs, int floors) {
        if (floors == 0 || floors == 1) {
            return floors;
        }

        if (eggs == 1) {
            return floors;
        }

        String key = eggs + "-" + floors;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int result = Integer.MAX_VALUE;
        for (int k = 1; k <= floors; k++) {
            int drops = 1 + Math.max(eggDropDPMemo(eggs - 1, k - 1), eggDropDPMemo(eggs, floors - k));
            result = Math.min(result, drops);
        }
        map.put(key, result);
        return result;
    }

    private static int eggDropDPTab(int eggs, int floors) {
        if (floors == 0 || floors == 1) {
            return floors;
        }

        int[][] dp = new int[eggs + 1][floors + 1];
        for (int i = 0; i <= floors; i++) {
            dp[1][i] = i;
        }

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
        System.out.println(eggDropDPMemo(2, 100));
        System.out.println(eggDropDPTab(2, 100));
    }
}
