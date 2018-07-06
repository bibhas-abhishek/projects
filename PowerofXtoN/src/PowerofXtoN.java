/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 28 May 2018
 * https://leetcode.com/problems/powx-n/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/PowerofXtoN
 **/

public class PowerofXtoN {

    private static double MyPow(double x, int n) {
        double result = 1;
        long absN = Math.abs((long) n);
        while (absN > 0) {
            if ((absN & 1) == 1)
                result *= x;
            absN >>= 1;
            x *= x;
        }
        return n < 0 ? 1 / result : result;
    }

    private static double myPow2(double x, int n) {
        if (n == 0)
            return 1.0;

        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n / 2;
        }

        if (n < 0) {
            x = 1.0 / x;
            n = -n;
        }

        if (n % 2 == 0)
            return myPow2(x * x, n / 2);
        else
            return myPow2(x * x, n / 2) * x;
    }

    public static void main(String[] args) {
        System.out.println(MyPow(2, -3));
    }

}
