import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/xor-quadruples/problem
 */
public class BeautifulQuadruples {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();
        int C = in.nextInt();
        int D = in.nextInt();
        int[] input = new int[]{A, B, C, D};
        Arrays.sort(input);
        beautifulQuadrupleCount(input);
    }

    private static void beautifulQuadrupleCount(int[] input) {
        int MAX = 3000;
        int XOR_MAX = (int) Math.pow(2, 12);
        int A = input[0];
        int B = input[1];
        int C = input[2];
        int D = input[3];

        int[] totalB = new int[MAX + 1];
        for (int i = 1; i <= A; i++)
            for (int j = i; j <= B; j++)
                totalB[j]++;

        for (int i = 1; i <= MAX; i++)
            totalB[i] += totalB[i - 1];

        int[][] countB = new int[MAX + 1][XOR_MAX + 1];
        for (int i = 1; i <= A; i++)
            for (int j = i; j <= B; j++)
                countB[j][i ^ j] += 1;

        for (int i = 0; i <= XOR_MAX; i++)
            for (int j = 1; j <= MAX; j++)
                countB[j][i] += countB[j - 1][i];

        long result = 0;
        for (int c = 1; c <= C; c++)
            for (int d = c; d <= D; d++)
                result += (totalB[c] - countB[c][c ^ d]);

        System.out.print(result);
    }

}
