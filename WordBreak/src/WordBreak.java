import java.util.ArrayList;
import java.util.List;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 17 Apr 2018
 * https://leetcode.com/problems/word-break/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/WordBreak
 **/

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] memo = new boolean[s.length() + 1];
        memo[0] = true; // empty string is contained in the dictionary

        // memo[i] means whether string of length i can be segmented from the dictionary
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (memo[j] && wordDict.contains(s.substring(j, i))) {
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(new WordBreak().wordBreak(s, wordDict));
    }
}
