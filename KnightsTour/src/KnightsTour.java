import java.util.Arrays;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 25 Sep 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/KnightsTour
 */

public class KnightsTour {

    private static boolean isSafe(int xPos, int yPos, int[][] tour, int n) {
        return xPos >= 0 & xPos < n && yPos >= 0 && yPos < n && tour[xPos][yPos] == -1;
    }

    private static boolean knightsTour(int[][] tour, int n) {
        for (int i = 0; i < n; i++)
            Arrays.fill(tour[i], -1);

        tour[0][0] = 1;
        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};
        if (!knightsTour(0, 0, 1, xMove, yMove, tour, n)) {
            System.out.println("No solution exists");
            return false;
        }
        return true;
    }

    private static boolean knightsTour(int xPos, int yPos, int index, int[] xMove, int[] yMove, int[][] tour, int n) {
        if (index == n * n)
            return true;

        int xNext, yNext, k;
        for (k = 0; k < n; k++) {
            xNext = xPos + xMove[k];
            yNext = yPos + yMove[k];
            if (isSafe(xNext, yNext, tour, n)) {
                tour[xNext][yNext] = index;
                if (knightsTour(xNext, yNext, index + 1, xMove, yMove, tour, n))
                    return true;

                tour[xNext][yNext] = -1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 8;
        int[][] tour = new int[n][n];
        knightsTour(tour, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(tour[i][j] + " ");
            System.out.println();
        }
    }

}
