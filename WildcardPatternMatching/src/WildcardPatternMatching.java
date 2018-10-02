/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 12 Sep 2018
 * https://leetcode.com/problems/wildcard-matching/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/WildcardPatternMatching
 */

public class WildcardPatternMatching {

    /*
        ‘?’ – matches any single character
        ‘*’ – matches any sequence of characters (including the empty sequence)
     */
    private static boolean match(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int j = 1; j <= m; j++) {
            if (pattern.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 1]; // '*' matches an empty pattern
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (pattern.charAt(j - 1) == '?' || text.charAt(i - 1) == pattern.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else if (pattern.charAt(j - 1) == '*')
                    dp[i][j] = dp[i][j - 1] // ignore *; check if remaining text/pattern match
                            || dp[i - 1][j]; // * equals the last text char; check if remaining match
                else
                    dp[i][j] = false; // redundant
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String text = "baaabab";
        String pattern = "*****ba*****ab";
        System.out.println(match(text, pattern));
    }

}
