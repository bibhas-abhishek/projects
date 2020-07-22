public class WildcardPatternMatching {

    /*
     * ‘?’ – matches any single character ‘*’ – matches any sequence of characters
     * (including the empty sequence)
     */
    public boolean match(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int j = 1; j <= m; j++) {
            if (pattern.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1]; // '*' matches an empty pattern
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (pattern.charAt(j - 1) == '?' || text.charAt(i - 1) == pattern.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if (pattern.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] // ignore *; check if remaining text/pattern match
                            || dp[i - 1][j]; // * equals the last text char; check if remaining match
                }
                else {
                    dp[i][j] = false; // if (pattern[j – 1] != text[i - 1])
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        // noinspection SpellCheckingInspection
        String text = "baaabab";
        String pattern = "*****ba*****ab";
        System.out.println(new WildcardPatternMatching().match(text, pattern));
    }
}
