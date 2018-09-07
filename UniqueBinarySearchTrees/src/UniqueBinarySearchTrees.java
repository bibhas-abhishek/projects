/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 15 Apr 2018
 * https://leetcode.com/problems/unique-binary-search-trees/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/UniqueBinarySearchTrees
 **/

public class UniqueBinarySearchTrees {

    public static void main(String[] args) {
        System.out.println(numTrees(5));
    }

    private static int numTrees(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                memo[i] += memo[j] * memo[i - j - 1];
            }
        }
        return memo[n];
    }

}
