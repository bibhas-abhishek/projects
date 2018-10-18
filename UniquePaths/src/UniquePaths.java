import java.util.HashMap;
import java.util.Map;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 18 Oct 2018
 * https://leetcode.com/problems/unique-paths/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/UniquePaths
 */

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        return uniquePaths(m - 1, n - 1, new HashMap<>());
    }

    public int uniquePaths(int m, int n, Map<String, Integer> memo) {
        if (m == 0 || n == 0)
            return 1;

        String key = m + "-" + n;
        if (memo.containsKey(key))
            return memo.get(key);

        int ways = 0;
        ways += uniquePaths(m - 1, n, memo) + uniquePaths(m, n - 1, memo);
        memo.put(key, ways);
        return ways;
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(7, 3));
    }

}
