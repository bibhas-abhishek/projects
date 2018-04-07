/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 04 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/RodCutting
 **/

public class RodCutting {

    private static int cutRod(int price[], int n) {
        if (n <= 0)
            return 0;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
            maxVal = Math.max(maxVal, price[i] + cutRod(price, n - i - 1));

        return maxVal;
    }

    private static int cutRodDP(int price[], int n) {
        if (n <= 0)
            return 0;

        int dp[] = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) { // i -> 1 to N
            int maxVal = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) { // j -> i
                maxVal = Math.max(maxVal, price[j] + dp[i - j - 1]);
                dp[i] = maxVal;
            }
        }
        return dp[n];
    }

    public static void main(String args[]) {
        int arr[] = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is " + cutRodDP(arr, size));

    }

}
