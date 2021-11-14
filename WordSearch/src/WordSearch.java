/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- projects: WordSearch
*- 14 Nov 2021 2:11 AM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
* https://leetcode.com/problems/word-search
-------------------------------------------*/

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (wordSearch(i, j, board, word, visited, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValidPosition(int r, int c, char[][] board, String word, boolean[][] visited,
                                    int index) {
        int rows = board.length;
        int cols = board[0].length;
        return r >= 0 && r < rows && c >= 0 && c < cols && !visited[r][c]
               && board[r][c] == word.charAt(index);
    }

    private boolean wordSearch(int r, int c, char[][] board, String word, boolean[][] visited,
                               int index) {
        if (index == word.length()) {
            return true;
        }

        if (!isValidPosition(r, c, board, word, visited, index)) {
            return false;
        }

        visited[r][c] = true;
        int[] moveX = { 1, 0, 0, -1 };
        int[] moveY = { 0, 1, -1, 0 };
        for (int i = 0; i < moveX.length; i++) {
            int nextX = r + moveX[i];
            int nextY = c + moveY[i];
            if (wordSearch(nextX, nextY, board, word, visited, index + 1)) {
                return true;
            }
        }
        visited[r][c] = false;
        return false;
    }
}
