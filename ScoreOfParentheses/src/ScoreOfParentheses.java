/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 09 Aug 2018
 * https://leetcode.com/problems/score-of-parentheses/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/ScoreOfParentheses
 */

public class ScoreOfParentheses {


    private static int scoreOfParentheses(String s) {
        int result = 0, balance = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                balance += 1;
            else {
                balance -= 1;
                if (s.charAt(i - 1) == '(')
                    result += 1 << balance;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(scoreOfParentheses("()(())"));
    }

}
