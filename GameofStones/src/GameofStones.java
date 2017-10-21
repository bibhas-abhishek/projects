import java.util.Arrays;
import java.util.Scanner;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 21 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/GameofStones
 * https://www.hackerrank.com/challenges/game-of-stones-1/problem
 */
public class GameofStones {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int[] memo = new int[101];
        Arrays.fill(memo, -1);
        memo[1] = 0;
        for (int i = 2; i <= 6; i++)
            memo[i] = 1;
        while (T-- > 0) {
            int n = in.nextInt();
            System.out.println(winner(n, memo) == 1 ? "First" : "Second");
        }
    }

    private static int winner(int n, int[] memo) {
        if (n <= 6 || memo[n] != -1)
            return memo[n];
        else if (winner(n - 2, memo) == 1
                && winner(n - 3, memo) == 1
                && winner(n - 5, memo) == 1) {
            memo[n] = 0;
        } else
            memo[n] = 1;
        return memo[n];
    }

}
