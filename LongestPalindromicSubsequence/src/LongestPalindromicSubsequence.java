import java.util.HashMap;
import java.util.Map;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 28 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/LongestPalindromicSubsequence
 **/

public class LongestPalindromicSubsequence {

    public int longestPalindromicSubsequence(char[] str) {
        return longestPalindromicSubsequence(str, 0, str.length - 1, new HashMap<>());
    }

    private int longestPalindromicSubsequence(char[] str, int start, int end, Map<String, Integer> memo) {
        if (start > end)
            return 0;

        if (start == end)
            return 1;

        String key = start + "-" + end;

        if (memo.containsKey(key))
            return memo.get(key);

        int res;
        if (str[start] == str[end])
            res = 2 + longestPalindromicSubsequence(str, start + 1, end - 1, memo);
        else
            res = Math.max(longestPalindromicSubsequence(str, start + 1, end, memo),
                    longestPalindromicSubsequence(str, start, end - 1, memo));

        memo.put(key, res);
        return res;
    }

    public int longestPalindromicSubsequenceDP(char[] str) {
        int n = str.length;
        int[][] dp = new int[n][n];
        // dp[i][j] -> Max length of palindrome from index i -> j, both inclusive
        for (int i = 0; i < n; i++)
            dp[i][i] = 1; // every string of length 1 is a palindrome

        for (int k = 2; k <= n; k++) {
            for (int i = 0; i <= n - k; i++) {
                int j = i + k - 1;
                if (str[i] == str[j])
                    dp[i][j] = ((k > 2) ? dp[i + 1][j - 1] : 0) + 2;
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][n - 1]; // top-right corner of matrix
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence obj = new LongestPalindromicSubsequence();
        String s = "agbdba";
        System.out.println(obj.longestPalindromicSubsequence(s.toCharArray()));
        System.out.println(obj.longestPalindromicSubsequenceDP(s.toCharArray()));
    }

}
