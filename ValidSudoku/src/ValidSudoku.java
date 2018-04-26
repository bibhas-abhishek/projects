import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 26 Apr 2018
 * https://leetcode.com/problems/valid-sudoku/description/
 * https://leetcode.com/problems/sudoku-solver/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/ValidSudoku
 **/

public class ValidSudoku {

    private static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> row = new HashSet<>();
            Set<Character> column = new HashSet<>();
            Set<Character> block = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !row.add(board[i][j]))
                    return false;

                if (board[j][i] != '.' && !column.add(board[j][i]))
                    return false;

                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);
                if (board[rowIndex + j / 3][colIndex + j % 3] != '.' && !block.add(board[rowIndex + j / 3][colIndex + j % 3]))
                    return false;
            }
        }
        return true;
    }

    private static boolean isValidInsert(char[][] board, int row, int col, char c) {
        int rowIndex = 3 * (row / 3);
        int colIndex = 3 * (col / 3);
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c)
                return false;

            if (board[i][col] == c)
                return false;

            if (board[rowIndex + i / 3][colIndex + i % 3] == c)
                return false;
        }
        return true;
    }


    private static boolean solve(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValidInsert(board, row, col, c)) {
                            board[row][col] = c;
                            if (solve(board))
                                return true;
                            else
                                board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static void solveSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return;
        solve(board);
        Arrays.stream(board).forEach(innerRow -> {
            for (char ch : innerRow) {
                System.out.print(ch + " ");
            }
            System.out.println();
        });
    }

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        solveSudoku(board);
    }

}
