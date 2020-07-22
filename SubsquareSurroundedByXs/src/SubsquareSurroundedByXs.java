public class SubsquareSurroundedByXs {

    private static class Cell {

        private int vt;
        private int hr;
    }

    private static int findSubsquare(char[][] input) {
        int n = input.length;
        int m = input[0].length;
        Cell[][] dp = new Cell[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = new Cell();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (input[i][j] == 'X') {
                    if (i == 0 && j == 0) {
                        dp[i][j].vt = 1;
                        dp[i][j].hr = 1;
                    }
                    else if (i == 0) {
                        dp[i][j].vt = 1;
                        dp[i][j].hr = dp[i][j - 1].hr + 1;
                    }
                    else if (j == 0) {
                        dp[i][j].vt = dp[i - 1][j].vt + 1;
                        dp[i][j].hr = 1;
                    }
                    else {
                        dp[i][j].vt = dp[i - 1][j].vt + 1;
                        dp[i][j].hr = dp[i][j - 1].hr + 1;
                    }
                }
            }
        }

        System.out.println("dp matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dp[i][j].vt + "," + dp[i][j].hr + " ");
            }
            System.out.println();
        }

        int max = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (dp[i][j].vt <= 1 || dp[i][j].hr <= 1) {
                    continue;
                }

                int min = Math.min(dp[i][j].vt, dp[i][j].hr);
                int k;
                for (k = min; k > 1; k--) {
                    if (dp[i][j - k + 1].vt >= k && dp[i - k + 1][j].hr >= k) {
                        break;
                    }
                }
                max = Math.max(max, k);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        char[][] input = {
                { 'O', 'O', 'O', 'O', 'O', 'X' },
                { 'O', 'X', 'O', 'X', 'X', 'X' },
                { 'O', 'X', 'O', 'X', 'O', 'X' },
                { 'O', 'X', 'X', 'X', 'X', 'X' },
                { 'O', 'O', 'O', 'O', 'O', 'O' }, };
        System.out.println(findSubsquare(input));
    }
}
