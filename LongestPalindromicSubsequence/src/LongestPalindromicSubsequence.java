import java.util.HashMap;
import java.util.Map;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 28 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/LongestPalindromicSubsequence
 **/

public class LongestPalindromicSubsequence {

    private static Map<String, Integer> hashMap = new HashMap<>();

    private static int longestPalindromicSubsequenceRec(char[] str, int start, int end) {
        if (start > end)
            return 0;

        if (start == end)
            return 1;

        String key = start + "-" + end;

        if (hashMap.containsKey(key))
            return hashMap.get(key);

        int res;
        if (str[start] == str[end])
            res = 2 + longestPalindromicSubsequenceRec(str, start + 1, end - 1);
        else
            res = Math.max(longestPalindromicSubsequenceRec(str, start + 1, end), longestPalindromicSubsequenceRec(str, start, end - 1));
        hashMap.put(key, res);
        return res;
    }

    private static int longestPalindromicSubsequenceDP(char[] str) {
        int[][] dp = new int[str.length][str.length];
        // dp[i][j] = Max length of palindrome from index i -> j, both inclusive
        for (int i = 0; i < str.length; i++)
            dp[i][i] = 1;

        for (int k = 2; k <= str.length; k++) {
            for (int i = 0; i <= str.length - k; i++) {
                int j = i + k - 1;
                if (str[i] == str[j])
                    dp[i][j] = ((k > 2) ? dp[i + 1][j - 1] : 0) + 2;
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][str.length - 1]; // top-right corner of matrix
    }

    public static void main(String[] args) {
        String s = "agbdba";
        System.out.println(longestPalindromicSubsequenceRec(s.toCharArray(), 0, s.length() - 1));
        System.out.println(longestPalindromicSubsequenceDP(s.toCharArray()));
    }

}
