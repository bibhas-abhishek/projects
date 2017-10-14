import java.util.Arrays;
import java.util.Scanner;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 14 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/GridChallenge
 * https://www.hackerrank.com/challenges/grid-challenge/problem
 */
public class GridChallenge {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        while (T-- > 0) {
            int N = Integer.parseInt(in.nextLine());
            boolean good = true;
            char[][] grid = new char[N][N];
            for (int i = 0; i < N; i++) {
                grid[i] = in.nextLine().toCharArray();
                Arrays.sort(grid[i]);
            }

            for (int col = 0; col < N && good; col++) {
                for (int row = 1; row < N; row++) {
                    good &= grid[row][col] >= grid[row - 1][col];
                }
            }

            System.out.println(good ? "YES" : "NO");
        }
    }

}
