import java.util.ArrayList;
import java.util.List;

public class NQueen {

    private static class Position {

        int row;
        int col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private void solveUtil(List<List<String>> resultList, Position[] positions, int row, int n) {
        if (row == n) {
            List<String> result = new ArrayList<>();
            for (Position p : positions) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    if (p.col == i) {
                        builder.append("Q");
                    }
                    else {
                        builder.append(".");
                    }
                }
                result.add(builder.toString());
            }
            resultList.add(result);
            return;
        }

        for (int col = 0; col < n; col++) {
            boolean isSafe = true;
            for (int prevQueen = 0; prevQueen < row; prevQueen++) {
                if (positions[prevQueen].col == col || positions[prevQueen].row - positions[prevQueen].col == row - col
                        || positions[prevQueen].row + positions[prevQueen].col == row + col) {
                    isSafe = false;
                    break; // column in attack with a queen; break; ++ column
                }
            }

            if (isSafe) {
                positions[row] = new Position(row, col);
                solveUtil(resultList, positions, row + 1, n);
            }
        }
    }

    public List<List<String>> solve(int n) {
        List<List<String>> resultList = new ArrayList<>();
        Position[] positions = new Position[n];
        solveUtil(resultList, positions, 0, n);
        return resultList;
    }

    public static void main(String args[]) {
        NQueen object = new NQueen();
        System.out.println(object.solve(4));
    }
}
