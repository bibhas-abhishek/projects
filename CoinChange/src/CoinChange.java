import java.util.HashMap;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 06 Apr 2018
 * https://www.hackerrank.com/challenges/coin-change/problem
 * https://leetcode.com/problems/coin-change/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/CoinChange
 **/
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 3};
        System.out.println(coinChange(coins, 4));
    }

    private static long coinChange(int[] coins, int amount) {
        return coinChangeHelperDP(coins, amount, 0, new HashMap<String, Long>());
    }

    private static long coinChangeHelperDP(int[] coins, int targetAmount, int index, HashMap<String, Long> memo) {
        if (targetAmount == 0)
            return 1;

        if (index >= coins.length)
            return 0;

        String key = targetAmount + "-" + index;

        if (memo.containsKey(key))
            return memo.get(key);

        int coinValue = coins[index]; // index tracks the type of coins. coinValue is the value of that coinType.
        long ways = 0;
        for (int i = 0; i * coinValue <= targetAmount; i++) {
            int remainingAmount = targetAmount - i * coinValue; // i tracks the number of coins of a particular type
            ways += coinChangeHelperDP(coins, remainingAmount, index + 1, memo);
        }
        memo.put(key, ways);
        return ways;
    }

    private static int coinChangeHelper(int[] coins, int amount, int index) {
        if (amount == 0)
            return 1;

        if (index >= coins.length)
            return 0;

        int coinAmount = coins[index];
        int ways = 0;
        for (int i = 0; i * coinAmount <= amount; i++) {
            int remainingAmount = amount - i * coinAmount;
            ways += coinChangeHelper(coins, remainingAmount, index + 1);
        }
        return ways;
    }

}