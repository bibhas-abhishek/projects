/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 27 Apr 2018
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 **/

public class LongestPalindromicSubstring {

    public int longestPalindromicSubstring(String str) {
        int n = str.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        int maxLength = 1;
        for (int k = 2; k <= n; k++) { // k -> result
            for (int i = 0; i <= n - k; i++) { // start index
                int j = i + k - 1;
                if (str.charAt(i) == str.charAt(j) && (k <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        System.out.println(str.substring(start, start + maxLength));
        return maxLength;
    }

    public static void main(String[] args) {
        //noinspection SpellCheckingInspection
        System.out.println(new LongestPalindromicSubstring().longestPalindromicSubstring("forgeeksskeegfor"));
    }
}
