/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 18 Apr 2018
 * https://leetcode.com/problems/decode-ways/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/DecodeWays
 **/

public class DecodeWays {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int n = s.length();
        int[] memo = new int[n + 1]; // memo[i] is the number of decoding for string of length i
        memo[0] = 1;
        memo[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <= 9)
                memo[i] += memo[i - 1];

            if (second >= 10 && second <= 26)
                memo[i] += memo[i - 2];
        }
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("123"));
    }

}
