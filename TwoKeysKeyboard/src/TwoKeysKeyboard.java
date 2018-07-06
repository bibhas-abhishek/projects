/**
 * Bibhas Abhishek
 * bibhas.abhishek@ril.com
 * 06 Jun 2018
 * https://leetcode.com/problems/2-keys-keyboard/description/
 * TwoKeysKeyboard: Copyright JioMoney 2018
 **/

public class TwoKeysKeyboard {

    private static int minSteps(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = i - 1; j > 0; j--) {
                if (i % j == 0) {
                    dp[i] = dp[j] + i / j;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(minSteps(3));
    }

}
