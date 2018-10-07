/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 04 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/RodCutting
 **/

public class RodCutting {

    public int cutRod(int price[], int n) {
        if (n <= 0)
            return 0;

        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
            maxVal = Math.max(maxVal, price[i] + cutRod(price, n - i - 1));

        return maxVal;
    }

    public int cutRodDP(int price[], int n) {
        if (n <= 0)
            return 0;

        int dp[] = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++)
                dp[i] = Math.max(dp[i], price[j] + dp[i - j - 1]);
        }
        return dp[n];
    }

    public static void main(String args[]) {
        RodCutting obj = new RodCutting();
        int arr[] = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(obj.cutRodDP(arr, arr.length));

    }

}
