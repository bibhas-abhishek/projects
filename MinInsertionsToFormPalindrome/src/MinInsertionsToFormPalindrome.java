/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 17 Sep 2018
 * https://www.geeksforgeeks.org/minimum-insertions-to-form-a-palindrome-dp-28/
 * https://github.com/bibhas-abhishek/projects/tree/master/MinInsertionsToFormPalindrome
 */

public class MinInsertionsToFormPalindrome {

    private static int findMinInsertions(char str[], int l, int r) {
        if (l > r)
            return 0;

        if (l == r)
            return 0;

        if (r == l + 1)
            return str[l] == str[r] ? 0 : 1;

        int result = 0;
        if (str[l] == str[r])
            result = findMinInsertions(str, l + 1, r - 1);
        else
            result = Math.max(findMinInsertions(str, l, r - 1), findMinInsertions(str, l + 1, r)) + 1;
        return result;
    }

    private static int findMinInsertionsDP(char str[], int n) {
        int[][] dp = new int[n][n];
        for (int diff = 1; diff < n; diff++) {
            for (int l = 0, r = diff; r < n; l++, r++) {
                if (str[l] == str[r])
                    dp[l][r] = dp[l + 1][r - 1];
                else
                    dp[l][r] = Math.min(dp[l + 1][r], dp[l][r - 1]) + 1;
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        String str = "abcda";
        System.out.println(findMinInsertions(str.toCharArray(), 0, str.length() - 1));
        System.out.println(findMinInsertionsDP(str.toCharArray(), str.length()));
    }

}
