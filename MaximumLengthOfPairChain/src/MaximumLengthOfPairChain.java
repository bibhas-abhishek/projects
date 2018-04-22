import java.util.Arrays;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 22 Apr 2018
 * https://leetcode.com/problems/maximum-length-of-pair-chain/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/MaximumLengthOfPairChain
 **/

public class MaximumLengthOfPairChain {

    private static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int N = pairs.length;
        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0])  // end of pair1 < start of pair2
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int ans = 0;
        for (int x : dp) {
            if (x > ans)
                ans = x;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] pairs = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println(findLongestChain(pairs));
    }

}
