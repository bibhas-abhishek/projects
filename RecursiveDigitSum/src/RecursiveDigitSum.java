import java.math.BigInteger;
import java.util.Scanner;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 14 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/RecursiveDigitSum
 * https://www.hackerrank.com/challenges/recursive-digit-sum/problem
 */
public class RecursiveDigitSum {

    public static void main(String[] args) {
        String[] input = new Scanner(System.in).nextLine().split(" ");
        String n = input[0];
        int k = Integer.parseInt(input[1]);
        System.out.println(superDigit(digitSum(n, k)));

    }

    private static String superDigit(String s) {
        if (s.length() == 1)
            return s;
        return superDigit(digitSum(s, 1));
    }

    private static String digitSum(String num, int k) {
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < num.length(); i++) {
            int tempSum = ((int) num.charAt(i) - '0') * k;
            sum = sum.add(new BigInteger(String.valueOf(tempSum)));
        }

        return sum.toString();
    }

}
