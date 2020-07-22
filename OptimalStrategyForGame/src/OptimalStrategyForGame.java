/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 17 Sep 2018
 * https://www.geeksforgeeks.org/optimal-strategy-for-a-game-dp-31/
 */

public class OptimalStrategyForGame {

    public int optimalStrategyNaive(int[] game, int i, int j) {
        if (game.length == 0) {
            return 0;
        }

        if (i == j) {
            return game[i];
        }

        if (j == i + 1) {
            return Math.max(game[i], game[j]);
        }
        return Math.max(
                game[i] + Math.min(optimalStrategyNaive(game, i + 2, j), optimalStrategyNaive(game, i + 1, j - 1)), // choose Vi
                game[j] + Math.min(optimalStrategyNaive(game, i + 1, j - 1), optimalStrategyNaive(game, i, j - 2))); // choose Vj
    }

    public int optimalStrategyDP(int[] game, int n) {
        int[][] dp = new int[n][n];
        int x, y, z;
        for (int diff = 0; diff < n; diff++) {
            for (int i = 0, j = diff; j < n; i++, j++) {
                x = ((i + 2) <= j) ? dp[i + 2][j] : 0;
                y = ((i + 1) <= (j - 1)) ? dp[i + 1][j - 1] : 0;
                z = (i <= (j - 2)) ? dp[i][j - 2] : 0;
                dp[i][j] = Math.max(game[i] + Math.min(x, y), game[j] + Math.min(y, z));
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        OptimalStrategyForGame obj = new OptimalStrategyForGame();
        int[] game = { 8, 15, 3, 7 };
        System.out.println(obj.optimalStrategyNaive(game, 0, game.length - 1));
        System.out.println(obj.optimalStrategyDP(game, game.length));
    }
}
