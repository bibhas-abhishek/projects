import java.util.Scanner;
import java.util.Stack;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 03 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/LongestCommonSubsequence
 * https://www.hackerrank.com/challenges/common-child/problem
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int result = longestCommonSubsequence(s1, s2);
        System.out.println(result);
    }

    private static int longestCommonSubsequence(String s1, String s2) {
        int[][] lcs = new int[s1.length() + 1][s2.length() + 1];
        int row = 0, col = 0;
        for (row = 1; row <= s1.length(); row++) {
            for (col = 1; col <= s2.length(); col++) {
                if (s1.charAt(col - 1) == s2.charAt(row - 1))
                    lcs[row][col] = lcs[row - 1][col - 1] + 1;
                else
                    lcs[row][col] = Math.max(lcs[row - 1][col], lcs[row][col - 1]);
            }
        }

        printLCSMatrix(lcs);
        printLCSequence(lcs, s1, s2);
        return lcs[row - 1][col - 1];
    }

    private static void printLCSequence(int[][] lcs, String s1, String s2) {
        int row = lcs.length - 1;
        int col = lcs[0].length - 1;
        Stack<Character> stack = new Stack<>();
        while (row > 0 && col > 0) {
            if (lcs[row][col] == lcs[row - 1][col - 1] + 1 && s1.charAt(col - 1) == s2.charAt(row - 1)) {
                stack.push(s1.charAt(col - 1));
                row--;
                col--;
            } else if (lcs[row][col] == lcs[row][col - 1]) {
                col--;
            } else if (lcs[row][col] == lcs[row - 1][col]) {
                row--;
            }
        }

        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
        System.out.println();
    }

    private static void printLCSMatrix(int[][] lcs) {
        for (int i = 0; i < lcs.length; i++) {
            for (int j = 0; j < lcs[0].length; j++)
                System.out.print(lcs[i][j] + " ");
            System.out.println();
        }
    }

}
