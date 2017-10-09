import java.util.Scanner;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 09 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/PowerSum
 * https://www.hackerrank.com/challenges/the-power-sum/problem
 */
public class PowerSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum = in.nextInt();
        int power = in.nextInt();
        System.out.print(getPowerSums(sum, power, 1));
    }

    private static int getPowerSums(int sum, int power, int num) {
        int value = sum - (int) Math.pow(num, power);
        if (value < 0)
            return 0;
        if (value == 0)
            return 0;
        else
            return getPowerSums(value, power, num + 1) + getPowerSums(sum, power, num + 1);
    }

}
