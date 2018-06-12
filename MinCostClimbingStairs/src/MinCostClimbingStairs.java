/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 30 May 2018
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/MinCostClimbingStairs
 **/

public class MinCostClimbingStairs {

    private static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= cost.length; i++)
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        return dp[cost.length];
    }

    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost));
    }

}
