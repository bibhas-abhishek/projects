/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 09 May 2018
 * https://leetcode.com/problems/longest-valid-parentheses/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/LongestValidParentheses
 **/

public class LongestValidParentheses {

    private static int longestValidParentheses(String s) {
        int result = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(')
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                else {
                    if (i - dp[i - 1] >= 1 && s.charAt(i - dp[i - 1] - 1) == '(')
                        dp[i] = dp[i - 1] + ((i - dp[i - 1] >= 2) ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                result = Math.max(result, dp[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")()())"));
    }

}
