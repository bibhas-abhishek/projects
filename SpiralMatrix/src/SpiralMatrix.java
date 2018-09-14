import java.util.ArrayList;
import java.util.List;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 10 Sep 2018
 * https://leetcode.com/problems/spiral-matrix/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/SpiralMatrix
 */

public class SpiralMatrix {

    private static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new ArrayList<>();

        return printSpiral(matrix, matrix.length, matrix[0].length, new ArrayList<>());
    }

    private static List<Integer> printSpiral(int[][] matrix, int m, int n, List<Integer> result) {
        int top = 0, bottom = m - 1, left = 0, right = n - 1, dir = 0;
        while (top <= bottom && left <= right) {
            if (dir == 0) {
                for (int i = left; i <= right; i++) {
                    result.add(matrix[top][i]);
                }
                top += 1;
            } else if (dir == 1) {
                for (int i = top; i <= bottom; i++) {
                    result.add(matrix[i][right]);
                }
                right -= 1;
            } else if (dir == 2) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom -= 1;
            } else if (dir == 3) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left += 1;
            }
            dir = (dir + 1) % 4;
        }
        return result;
    }

    public static void main(String[] args) {
        int matrix[][] = {{2, 4, 6, 8},
                {5, 9, 12, 16},
                {2, 11, 5, 9},
                {3, 2, 1, 8}};
        List<Integer> result = spiralOrder(matrix);
        result.stream().mapToInt(e -> e).mapToObj(e -> e + " ").forEach(System.out::print);
    }

}
