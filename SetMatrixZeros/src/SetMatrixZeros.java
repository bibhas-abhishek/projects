/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 06 Oct 2018
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/SetMatrixZeros
 */

public class SetMatrixZeros {

    public void setZeroes(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < row.length; i++) {
            if (row[i])
                nullifyRow(matrix, i);
        }

        for (int j = 0; j < col.length; j++) {
            if (col[j])
                nullifyCol(matrix, j);
        }
    }

    private void nullifyCol(int[][] matrix, int j) {
        for (int i = 0; i < matrix.length; i++)
            matrix[i][j] = 0;
    }

    private void nullifyRow(int[][] matrix, int i) {
        for (int j = 0; j < matrix[0].length; j++)
            matrix[i][j] = 0;
    }

    private void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};
        SetMatrixZeros obj = new SetMatrixZeros();
        obj.setZeroes(matrix);
        obj.printMatrix(matrix);
    }

}
