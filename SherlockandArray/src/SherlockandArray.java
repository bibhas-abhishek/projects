import java.util.Scanner;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 20 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/SherlockAndArray
 * https://www.hackerrank.com/challenges/sherlock-and-array/problem
 */
public class SherlockAndArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int n = in.nextInt();
            int[] array = new int[n];
            int index = 0;
            for (int i = 0; i < n; i++)
                array[index++] = in.nextInt();
            System.out.println(solve(array));
        }
    }

    private static String solve(int[] array) {
        int sum = 0;
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            if (sum >= 0)
                sum -= array[j--];
            else
                sum += array[i++];

        }
        return sum == 0 ? "YES" : "NO";
    }

}
