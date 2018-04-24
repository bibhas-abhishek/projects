/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 03 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/TestBed
 */
public class TestBed {

    private static int cost(int[] B) {
        int[][] dp = new int[100001][2];
        int n = B.length;
        for (int i = 0; i < n - 1; i++) {
            dp[i + 1][0] = Math.max(dp[i][0], dp[i][1] + Math.abs(B[i] - 1));
            dp[i + 1][1] = Math.max(dp[i][0] + Math.abs(B[i + 1] - 1), dp[i][1] + Math.abs(B[i] - B[i + 1]));
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    public static void main(String[] args) {
        int[] array = {10, 1, 10, 1, 10};
        System.out.println(cost(array));
    }

}
