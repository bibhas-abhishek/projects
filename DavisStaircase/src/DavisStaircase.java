import java.util.Arrays;
import java.util.Scanner;

public class DavisStaircase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for (int i = 0; i < s; i++) {
            int n = in.nextInt();
            int[] memo = new int[n];
            Arrays.fill(memo, -1);
            System.out.println(countWays(n, memo));
        }
    }

    private static int countWays(int n, int[] memo) {
        if (n < 0)
            return 0;
        else if (n == 0)
            return 1;
        else if (memo[n - 1] != -1)
            return memo[n - 1];
        else {
            memo[n - 1] = countWays(n - 3, memo) + countWays(n - 2, memo) + countWays(n - 1, memo);
            return memo[n - 1];
        }
    }

}
