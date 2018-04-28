/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 27 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/LongestPalindromicSubstring
 **/

public class LongestPalindromicSubstring {

    private static int longestPalindromicSubstring1(String str) {
        int n = str.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++)
            dp[i][i] = true;

        int length = 0;
        for (int k = 2; k <= n; k++) {
            for (int i = 0; i <= n - k; i++) { // start index
                int j = i + k - 1;
                if (str.charAt(i) == str.charAt(j) && (k <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    length = Math.max(length, k);
                }
            }
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromicSubstring1("forgeeksskeegfor"));
    }

}
