import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 06 Nov 2018
 * https://leetcode.com/problems/triangle/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/Triangle
 */

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = i == n - 1 ? triangle.get(i).get(j) :
                        Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> t = new ArrayList<>(Arrays.asList(2));
        triangle.add(t);
        t = new ArrayList<>(Arrays.asList(3, 4));
        triangle.add(t);
        t = new ArrayList<>(Arrays.asList(6, 5, 7));
        triangle.add(t);
        t = new ArrayList<>(Arrays.asList(4, 1, 8, 3));
        triangle.add(t);
        System.out.println(new Triangle().minimumTotal(triangle));
    }

}
