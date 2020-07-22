import java.util.HashMap;
import java.util.Map;

public class LongestPalindromicSubsequence {

    public int longestPalindromicSubsequenceDPMemo(char[] str) {
        return longestPalindromicSubsequenceDPMemo(str, 0, str.length - 1, new HashMap<>());
    }

    private int longestPalindromicSubsequenceDPMemo(char[] str, int start, int end, Map<String, Integer> memo) {
        if (start > end) {
            return 0;
        }

        if (start == end) {
            return 1;
        }

        String key = start + "-" + end;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int res;
        if (str[start] == str[end]) {
            res = 2 + longestPalindromicSubsequenceDPMemo(str, start + 1, end - 1, memo);
        }
        else {
            res = Math.max(
                    longestPalindromicSubsequenceDPMemo(str, start + 1, end, memo),
                    longestPalindromicSubsequenceDPMemo(str, start, end - 1, memo));
        }
        memo.put(key, res);
        return res;
    }

    public int longestPalindromicSubsequenceDPTab(char[] str) {
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
                }
                else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence obj = new LongestPalindromicSubsequence();
        // noinspection SpellCheckingInspection
        String s = "agbdba";
        System.out.println(obj.longestPalindromicSubsequenceDPMemo(s.toCharArray()));
        System.out.println(obj.longestPalindromicSubsequenceDPTab(s.toCharArray()));
    }
}
