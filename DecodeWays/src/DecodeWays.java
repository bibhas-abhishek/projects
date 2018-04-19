/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 18 Apr 2018
 * https://leetcode.com/problems/decode-ways/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/DecodeWays
 **/

public class DecodeWays {

    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
    }

    private static int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int n = s.length();
        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            int iMinus1Substring = Integer.valueOf(s.substring(i - 1, i));
            int iMinus2Substring = Integer.valueOf(s.substring(i - 2, i));
            if (iMinus1Substring >= 1 && iMinus1Substring <= 9)
                memo[i] += memo[i - 1];

            if (iMinus2Substring >= 10 && iMinus2Substring <= 26)
                memo[i] += memo[i - 2];
        }
        return memo[n];
    }

}
