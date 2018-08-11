import java.util.HashMap;
import java.util.Map;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 28 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/EditDistance
 **/

public class EditDistance {

    private static int minDistanceTopDown(String word1, String word2) {
        return minDistanceTopDown(word1, word2, 0, 0, new HashMap<>());
    }

    private static int minDistanceTopDown(String word1, String word2, int index1, int index2, Map<String, Integer> memo) {
        if (index1 == word1.length())
            return word2.length() - index2;

        if (index2 == word2.length())
            return word1.length() - index1;

        String key = index1 + "-" + index2;
        if (memo.containsKey(key))
            return memo.get(key);

        int result;
        if (word1.charAt(index1) == word2.charAt(index2))
            result = minDistanceTopDown(word1, word2, index1 + 1, index2 + 1, memo);
        else
            result = 1 + Math.min(minDistanceTopDown(word1, word2, index1 + 1, index2 + 1, memo),  // replace
                    Math.min(minDistanceTopDown(word1, word2, index1 + 1, index2, memo),                  // delete from word1
                            minDistanceTopDown(word1, word2, index1, index2 + 1, memo)));                 // add to word1

        memo.put(key, result);
        return result;
    }

    private static int minDistanceBottomUp(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < dp.length; i++)
            dp[i][0] = i;

        for (int j = 0; j < dp[0].length; j++)
            dp[0][j] = j;

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        System.out.println(minDistanceTopDown("sunday", "saturday"));
        System.out.println(minDistanceBottomUp("sunday", "saturday"));
    }

}
