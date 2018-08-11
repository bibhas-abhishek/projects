/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 11 Aug 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/EncodingDigitSequence
 */

public class EncodingDigitSequence {

    private static int countDecodingDP(int[] digits, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1; // TODO: why dp[0] == 1?
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (digits[i - 1] > 0)
                dp[i] = dp[i - 1];

            if (digits[i - 2] == 1 || (digits[i - 2] == 2 && digits[i - 1] < 7))
                dp[i] += dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] digits = {1, 2, 3};
        System.out.println(countDecodingDP(digits, digits.length));
    }

}
