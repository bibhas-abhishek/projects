/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- projects: SortedMatrixSearch
*- 08 Nov 2021 8:46 PM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
* https://leetcode.com/problems/search-a-2d-matrix
-------------------------------------------*/

public class SortedMatrixSearch {

    private static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            int current = matrix[row][col];
            if (current == target) {
                return true;
            }
            if (current > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
        System.out.println(searchMatrix(matrix, 11));
    }
}
