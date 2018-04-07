/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 07 Apr 2018
 * https://leetcode.com/problems/search-a-2d-matrix/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/SortedMatrixSearch
 **/

public class SortedMatrixSearch {

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}};
        System.out.println(searchMatrix(matrix, 11));
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            int current = matrix[row][col];
            if (current == target)
                return true;
            if (current > target)
                col--;
            else
                row++;
        }
        return false;
    }

}
