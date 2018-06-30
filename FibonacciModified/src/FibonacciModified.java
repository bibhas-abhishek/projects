import java.math.BigInteger;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 14 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/FibonacciModified
 * https://www.hackerrank.com/challenges/fibonacci-modified/problem
 */
public class FibonacciModified {

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        BigInteger t1 = in.nextBigInteger();
        BigInteger t2 = in.nextBigInteger();
        int n = in.nextInt();
        BigInteger[] memo = new BigInteger[n];
        for (int i = 0; i < memo.length; i++)
            memo[i] = new BigInteger("-1");
        memo[0] = t1;
        memo[1] = t2;
        BigInteger bigInteger = modifiedFastFib(memo, n - 1);
        System.out.print(bigInteger.toString());*/
        System.out.println(fastFibonacci(2));
    }

    private static BigInteger modifiedFastFib(BigInteger[] memo, int n) {
        if (n == 0)
            return memo[0];
        else if (n == 1)
            return memo[1];
        else if (memo[n].compareTo(new BigInteger("-1")) != 0)
            return memo[n];
        else {
            memo[n] = modifiedFastFib(memo, n - 2).add
                    (modifiedFastFib(memo, n - 1).multiply(modifiedFastFib(memo, n - 1)));
            return memo[n];
        }
    }

    private static int fastFibonacci(int n) {
        if (n <= 1)
            return n;

        int nMinus1 = 1, nMinus2 = 0;
        for (int i = 2; i <= n; i++) {
            int nMinus0 = nMinus1 + nMinus2;
            nMinus2 = nMinus1;
            nMinus1 = nMinus0;
        }
        return nMinus1;
    }

}
