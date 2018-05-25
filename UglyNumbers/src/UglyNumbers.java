/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 07 May 2018
 * https://leetcode.com/problems/ugly-number-ii/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/UglyNumbers
 **/

public class UglyNumbers {

    private static int maxDivide(int n, int factor) {
        while (n % factor == 0)
            n /= factor;
        return n;
    }

    private static boolean isUgly(int n) {
        n = maxDivide(n, 2);
        n = maxDivide(n, 3);
        n = maxDivide(n, 5);
        return n == 1;
    }

    private static int nthUglyNumber(int n) {
        int uglyCount = 1;
        int num = 1;
        while (uglyCount < n) {
            num += 1;
            if (isUgly(num))
                uglyCount += 1;
        }
        return num;
    }

    private static int nthUglyNumberII(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            int nextMultiple2 = dp[i2] * 2;
            int nextMultiple3 = dp[i3] * 3;
            int nextMultiple5 = dp[i5] * 5;
            dp[i] = Math.min(nextMultiple2, Math.min(nextMultiple3, nextMultiple5));
            if (dp[i] == nextMultiple2)
                i2 += 1;
            if (dp[i] == nextMultiple3)
                i3 += 1;
            if (dp[i] == nextMultiple5)
                i5 += 1;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(1352));
        System.out.println(nthUglyNumberII(1352));
    }

}
