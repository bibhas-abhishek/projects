/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 21 Oct 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/RMQSparseTable
 */

/**
 * buildTree: O(nlogn)
 * getMin: O(1)
 */
public class RMQSparseTable {

    private int log2(int n) {
        return (int) (Math.log(n) / Math.log(2));
    }

    public int[][] buildSparseTable(int[] input, int n) {
        int[][] sparse = new int[n][log2(n) + 1];
        for (int i = 0; i < n; i++)
            sparse[i][0] = i;

        for (int j = 1; 1 << j <= n; j++) {
            for (int i = 0; i + (1 << j) + 1 < n; i++) {
                if (input[sparse[i][j - 1]] < input[sparse[i + (1 << (j - 1))][j - 1]])
                    sparse[i][j] = sparse[i][j - 1];
                else
                    sparse[i][j] = sparse[i + (1 << (j - 1))][j - 1];
            }
        }
        return sparse;
    }

    public int rangeMinimumQuery(int low, int high, int[] input, int[][] sparse) {
        int r = high - low + 1;
        int k = log2(r);
        return Math.min(input[sparse[low][k]], input[sparse[low + r - (1 << k)][k]]);
    }

    public static void main(String[] args) {
        int[] input = {2, 5, 3, 6, 4, 1, -1, 3, 4, 2};
        RMQSparseTable obj = new RMQSparseTable();

        int[][] sparse = obj.buildSparseTable(input, input.length);
        for (int i = 0; i < input.length; i++) {
            for (int j = i; j < input.length; j++) {
                System.out.print("(" + i + "," + j + ")=" + obj.rangeMinimumQuery(i, j, input, sparse) + "  ");
            }
            System.out.println();
        }
    }

}
