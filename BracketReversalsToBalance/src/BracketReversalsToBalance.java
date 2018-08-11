import java.util.Stack;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 11 Aug 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/BracketReversalsToBalance
 */

public class BracketReversalsToBalance {

    static private int countMinReversals(String expr) {
        Stack<Character> stack = new Stack<>();
        for (char c : expr.toCharArray()) {
            if (c == '}' && !stack.empty()) {
                if (stack.peek() == '{')
                    stack.pop();
                else
                    stack.push(c);
            } else
                stack.push(c);
        }

        int n = 0, stackSize = stack.size();
        while (!stack.isEmpty() && stack.peek() == '{') {
            stack.pop();
            n += 1;
        }
        int m = stackSize - n;
        return (int) (Math.ceil(m / 2.0) + Math.ceil(n / 2.0));
    }

    public static void main(String[] args) {
        System.out.println(countMinReversals("}}}{{{{{"));
    }

}
