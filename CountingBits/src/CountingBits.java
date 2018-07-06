import java.util.Arrays;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 08 May 2018
 * https://leetcode.com/problems/counting-bits/
 * https://github.com/bibhas-abhishek/projects/tree/master/CountingBits
 **/

public class CountingBits {

    private static int nearestPowerof2(int n) {
        if (n <= 1)
            return 0;

        if ((n & (n - 1)) == 0)
            return n;

        int count = 0;
        while (n != 0) {
            n >>= 1;
            count += 1;
        }
        return 1 << count - 1;
    }

    private static int[] countBits(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;
        if (num < 1)
            return dp;

        dp[1] = 1;
        for (int i = 2; i <= num; i++) {
            int nearestPowerof2 = nearestPowerof2(i);
            dp[i] = 1 + dp[i - nearestPowerof2];
        }
        return dp;
    }

    public static void main(String[] args) {
        int[] result = countBits(2);
        Arrays.stream(result).mapToObj(key -> key + " ").forEach(System.out::print);
    }

}
