/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 10 Sep 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/RotateMatrix
 */

public class RotateMatrix {

    private static void rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length)
            return;

        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - layer - 1;
            for (int i = first; i < last; i++) {
                int offset = i - first;

                int top = matrix[first][i]; // save top

                matrix[first][i] = matrix[last - offset][first]; // left -> top

                matrix[last - offset][first] = matrix[last][last - offset]; // bottom -> left

                matrix[last][last - offset] = matrix[i][last]; // right -> bottom

                matrix[i][last] = top; // saved top -> right
            }
        }
    }

    /*top
    first         | i
    last - offset | first
    last          | last - offset
    i             | last
    top*/

    private static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        rotate(matrix);
        print(matrix);
    }

}
