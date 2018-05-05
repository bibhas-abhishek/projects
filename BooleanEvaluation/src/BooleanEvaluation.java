import java.util.HashMap;
import java.util.Map;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 05 May 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/BooleanEvaluation
 **/

public class BooleanEvaluation {

    public static void main(String[] args) {
        String expression = "0&0&0&1^1|0";
        boolean result = true;
        System.out.println(countEval(expression, result));
    }

    private static int countEval(String s, boolean result) {
        return countEval(s, result, new HashMap<>());
    }

    private static boolean stringToBool(String s) {
        return s.equals("1");
    }

    private static int countEval(String s, boolean result, Map<String, Integer> memo) {
        if (s.length() == 0)
            return 0;

        if (s.length() == 1) {
            return stringToBool(s) == result ? 1 : 0;
        }

        String key = s + "-" + result;
        if (memo.containsKey(key))
            return memo.get(key);

        int ways = 0;
        for (int i = 1; i < s.length(); i += 2) {
            char c = s.charAt(i);
            String left = s.substring(0, i);
            String right = s.substring(i + 1, s.length());
            int leftTrue = countEval(left, true, memo);
            int rightTrue = countEval(right, true, memo);
            int leftFalse = countEval(left, false, memo);
            int rightFalse = countEval(right, false, memo);
            int totalWays = (leftTrue + leftFalse) * (rightTrue + rightFalse);
            int trueWays = 0;
            switch (c) {
                case '&':
                    trueWays = leftTrue * rightTrue;
                    break;
                case '^':
                    trueWays = leftTrue * rightFalse + leftFalse * rightTrue;
                    break;
                case '|':
                    trueWays = leftTrue * rightTrue + leftTrue * rightFalse + rightTrue * leftFalse;
                    break;
            }
            ways += result ? trueWays : totalWays - trueWays;
        }
        memo.put(key, ways);
        return ways;
    }

}
