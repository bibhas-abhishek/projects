import java.util.HashMap;
import java.util.Map;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 06 May 2018
 * https://leetcode.com/problems/valid-parenthesis-string/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/ValidParenthesisString
 **/

public class ValidParenthesisString {

    private static boolean checkValidString(String s) {
        return solve(s, 0, 0, new HashMap<>());
    }

    private static boolean solve(String s, int balance, int index, Map<String, Boolean> memo) {
        if (index >= s.length())
            return balance == 0;

        if (balance < 0)
            return false;

        String key = balance + "-" + index;
        if (memo.containsKey(key))
            return memo.get(key);

        boolean result;
        if (s.charAt(index) == '(')
            result = solve(s, balance + 1, index + 1, memo);
        else if (s.charAt(index) == ')')
            result = solve(s, balance - 1, index + 1, memo);
        else
            result = solve(s, balance + 1, index + 1, memo)
                    || solve(s, balance - 1, index + 1, memo)
                    || solve(s, balance, index + 1, memo);

        memo.put(key, result);
        return result;
    }

    private static boolean checkValidString2(String s) {
        int low = 0, high = 0;
        for (char c : s.toCharArray()) {
            low += c == '(' ? 1 : -1;
            high += c != ')' ? 1 : -1;
            if (high < 0)
                break;
            low = Math.max(low, 0);
        }
        return low == 0;
    }

    public static void main(String[] args) {
        System.out.println(checkValidString2("(*)))"));
    }

}
