import java.util.Arrays;
import java.util.Scanner;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 14 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/MaximumPerimeterTriangle
 * https://www.hackerrank.com/challenges/maximum-perimeter-triangle/problem
 */
public class MaximumPerimeterTriangle {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] l = new int[n];
        for (int i = 0; i < n; i++)
            l[i] = in.nextInt();

        solve(l);
    }

    private static void solve(int[] l) {
        if (l.length < 3) {
            System.out.println(-1);
            return;
        }

        Arrays.sort(l);
        for (int i = l.length - 3; i >= 0; i--) {
            if (l[i] + l[i + 1] > l[i + 2]) {
                System.out.println(l[i] + " " + l[i + 1] + " " + l[i + 2]);
                return;
            }
        }

        System.out.println(-1);
    }

}
