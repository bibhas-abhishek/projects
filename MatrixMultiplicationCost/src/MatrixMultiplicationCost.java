/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 07 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/MatrixMultiplicationCost
 **/

public class MatrixMultiplicationCost {


    private static int matrixChainOrder(int p[], int i, int j) {
        if (i == j)
            return 0;

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int count = matrixChainOrder(p, i, k) +
                    matrixChainOrder(p, k + 1, j) +
                    p[i - 1] * p[j] * p[k];

            if (count < min)
                min = count;
        }
        return min;
    }

    private static int matrixChainOrderDP(int arr[]) {
        int temp[][] = new int[arr.length][arr.length];
        int q;
        for (int l = 2; l < arr.length; l++) {
            for (int i = 0; i < arr.length - l; i++) {
                int j = i + l;
                temp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    q = temp[i][k] + temp[k][j] + arr[i] * arr[k] * arr[j];
                    if (q < temp[i][j]) {
                        temp[i][j] = q;
                    }
                }
            }
        }
        return temp[0][arr.length - 1];
    }

    public static void main(String args[]) {
        int arr[] = new int[]{1, 2, 3, 4, 3};
        // int cost = matrixChainOrder(arr, 1, arr.length - 1);
        int cost = matrixChainOrderDP(arr);
        System.out.print(cost);
    }

}
