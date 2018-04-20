import java.util.ArrayList;
import java.util.List;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 20 Apr 2018
 * https://leetcode.com/problems/n-queens/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/NQueen
 **/

public class NQueen {

    private static class Position {

        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

    }

    private static List<List<String>> solveNQueens(int n) {
        List<List<String>> resultList = new ArrayList<>();
        Position[] positions = new Position[n];
        solveNQueens(resultList, positions, 0, n);
        return resultList;
    }

    private static void solveNQueens(List<List<String>> resultList, Position[] positions, int row, int n) {
        if (row == n) {
            List<String> result = new ArrayList<>();
            for (Position p : positions) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < n; i++) { // evaluate every row -> column by column
                    if (p.col == i)
                        builder.append("Q");
                    else
                        builder.append(".");
                }
                result.add(builder.toString());
                builder = new StringBuilder();
            }
            resultList.add(result);
            return;
        }

        for (int col = 0; col < n; col++) {
            boolean foundSafe = true;
            for (int queen = 0; queen < row; queen++) {
                if (positions[queen].col == col || positions[queen].row - positions[queen].col == row - col ||
                        positions[queen].row + positions[queen].col == row + col) {
                    foundSafe = false;
                    break;  // skip current column
                }
            }

            if (foundSafe) {
                positions[row] = new Position(row, col);
                solveNQueens(resultList, positions, row + 1, n);
            }
        }
    }

    public static void main(String args[]) {
        System.out.println(solveNQueens(4));
    }

}
