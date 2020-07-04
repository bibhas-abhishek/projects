/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 31 Oct 2018
 * https://leetcode.com/problems/surrounded-regions/
 */

public class SurroundedRegions {

    private boolean isValid(char[][] board, int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m && board[x][y] == 'O';
    }

    private void dfs(char[][] board, int x, int y, int n, int m, int[] xMove, int[] yMove) {
        board[x][y] = 'B';
        for (int k = 0; k < xMove.length; k++) {
            int nextX = x + xMove[k];
            int nextY = y + yMove[k];
            if (isValid(board, nextX, nextY, n, m)) {
                dfs(board, nextX, nextY, n, m, xMove, yMove);
            }
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        if (n == 0) {
            return;
        }

        int[] xMove = { 0, 0, 1, -1 };
        int[] yMove = { 1, -1, 0, 0 };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    if (board[i][j] == 'O') {
                        dfs(board, i, j, n, m, xMove, yMove);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // nodes marked B are accessible from the border
                if (board[i][j] == 'B') {
                    board[i][j] = 'O';
                }
                // nodes still marked O are not accessible from the border
                else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board =
                { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' }, { 'X', 'O', 'X', 'X' } };
        new SurroundedRegions().solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
