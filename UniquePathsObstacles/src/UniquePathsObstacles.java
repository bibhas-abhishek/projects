/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 18 Oct 2018
 * https://leetcode.com/problems/unique-paths-ii/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/UniquePathsObstacles
 */

public class UniquePathsObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1)
            return 0;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0)
                dp[i][0] = 1;
            else break;
        }

        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 0)
                dp[0][j] = 1;
            else break;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePathsObstacles obj = new UniquePathsObstacles();
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}};
        System.out.println(obj.uniquePathsWithObstacles(obstacleGrid));
    }

}
