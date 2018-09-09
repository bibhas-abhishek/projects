/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 10 Sep 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/SpiralMatrix
 */

public class SpiralMatrix {

    private static void printSpiral(int[][] matrix, int m, int n) {
        int top = 0, bottom = m - 1, left = 0, right = n - 1, dir = 0;
        while (top <= bottom && left <= right) {
            if (dir == 0) {
                for (int i = left; i <= right; i++) {
                    System.out.print(matrix[top][i] + " ");
                }
                top += 1;
            } else if (dir == 1) {
                for (int i = top; i <= bottom; i++) {
                    System.out.print(matrix[i][right] + " ");
                }
                right -= 1;
            } else if (dir == 2) {
                for (int i = right; i >= left; i--) {
                    System.out.print(matrix[bottom][i] + " ");
                }
                bottom -= 1;
            } else if (dir == 3) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left += 1;
            }
            dir = (dir + 1) % 4;
        }
    }

    public static void main(String[] args) {
        int matrix[][] = {{2, 4, 6, 8},
                {5, 9, 12, 16},
                {2, 11, 5, 9},
                {3, 2, 1, 8}};
        printSpiral(matrix, matrix.length, matrix[0].length);
    }

}
