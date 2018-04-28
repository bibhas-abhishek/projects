import java.util.HashMap;
import java.util.Map;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 28 Apr 2018
 * https://leetcode.com/problems/interleaving-string/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/InterleavingString
 **/

public class InterleavingString {

    private static boolean isInterleaveMemo(String s1, String s2, String s3) {
        return (s1.length() + s2.length() == s3.length()
                && isInterleaveMemo(s1, 0, s2, 0, s3, 0, new HashMap<>()));
    }

    private static boolean isInterleaveMemo(String s1, int i, String s2, int j, String s3, int k, Map<String, Boolean> memo) {
        if (k == s3.length())
            return true;

        String key = i + "-" + j + "-" + k;
        if (memo.containsKey(key))
            return memo.get(key);

        boolean result = (i < s1.length() && s1.charAt(i) == s3.charAt(k) && isInterleaveMemo(s1, i + 1, s2, j, s3, k + 1, memo)) ||
                (j < s2.length() && s2.charAt(j) == s3.charAt(k) && isInterleaveMemo(s1, i, s2, j + 1, s3, k + 1, memo));

        memo.put(key, result);
        return result;
    }

    private static boolean isInterleaveDP(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length())
            return false;

        boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j];
                } else
                    dp[i][j] = (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j])
                            || (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1]);
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println(isInterleaveDP(s1, s2, s3));
    }

}
