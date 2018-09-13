/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 13 Sep 2018
 * https://leetcode.com/problems/regular-expression-matching/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/RegexMatching
 */

public class RegexMatching {

    private static boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;

        char[] text = s.toCharArray();
        char[] pattern = p.toCharArray();
        int n = text.length;
        int m = pattern.length;
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int j = 1; j <= m; j++) {
            if (pattern[j - 1] == '*')
                dp[0][j] = (j - 2) >= 0 && dp[0][j - 2];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text[i - 1] == pattern[j - 1] || pattern[j - 1] == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (pattern[j - 1] == '*') {
                    dp[i][j] = dp[i][j - 2]; // taking 0 occurrence of the pattern character preceding *
                    /*
                     * x a *
                     * x
                     * a
                     *
                     * pattern[j - 2] == text[i - 1] -> the current text character equals the pattern character preceding
                     * * & is considered part of * stream
                     * pattern[j - 2] == '.' -> the pattern character preceding * is '.' that matches
                     * (any) current text character
                     */
                    if (pattern[j - 2] == '.' || pattern[j - 2] == text[i - 1])
                        dp[i][j] |= dp[i - 1][j];
                } else
                    dp[i][j] = false; // redundant
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        // String text = "mississippi", pattern = "mis*is*p*.";
        String text = "aab", pattern = "c*a*b";
        System.out.println(isMatch(text, pattern));
    }

}
