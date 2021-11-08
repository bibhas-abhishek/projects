/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- projects: LongestPalindromicSubsequence
*- 07 Nov 2021 6:08 PM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
* https://leetcode.com/problems/longest-palindromic-subsequence/
-------------------------------------------*/

public class LongestPalindromicSubsequence {

    public int longestPalindromicSubsequence(char[] str) {
        int n = str.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int k = 2; k <= n; k++) {
            for (int i = 0; i <= n - k; i++) {
                int j = i + k - 1;
                if (str[i] == str[j]) {
                    dp[i][j] = ((k > 2) ? dp[i + 1][j - 1] : 0) + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence driver = new LongestPalindromicSubsequence();
        String s = "agbdba";
        System.out.println(driver.longestPalindromicSubsequence(s.toCharArray()));
    }
}
