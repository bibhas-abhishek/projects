/**
 * https://leetcode.com/problems/house-robber/description/
 **/

public class HouseRobber {

    public int rob(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        else if (arr.length == 1) {
            return arr[0];
        }

        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(arr[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[arr.length - 1];
    }

    public static void main(String[] args) {
        int[] arr = { 2, 7, 9, 3, 1 };
        System.out.println(new HouseRobber().rob(arr));
    }
}
