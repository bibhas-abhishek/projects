import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger t1 = in.nextBigInteger();
        BigInteger t2 = in.nextBigInteger();
        int n = in.nextInt();
        BigInteger[] memo = new BigInteger[n];
        for (int i = 0; i < memo.length; i++)
            memo[i] = new BigInteger("-1");
        memo[0] = t1;
        memo[1] = t2;
        BigInteger bigInteger = modifiedFastFib(memo, n - 1);
        System.out.print(bigInteger.toString());
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

}
