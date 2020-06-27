import java.util.Stack;

public class BalancedBrackets {

    private static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        boolean flag = true;
        int i = 0;
        while (i < s.length() && flag) {
            char element = s.charAt(i);
            if (element == '(' || element == '{' || element == '[')
                stack.push(element);
            else {
                if (stack.isEmpty() || element != returnMatchedBracket(stack.pop())) {
                    flag = false;
                }
            }
            i++;
        }
        return flag && stack.isEmpty() ? "YES" : "NO";
    }

    private static Character returnMatchedBracket(char c) {
        Character bracket = null;
        switch (c) {
            case '(':
                bracket = ')';
                break;
            case '{':
                bracket = '}';
                break;
            case '[':
                bracket = ']';
                break;
        }
        return bracket;
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("[]({[})"));
    }
}
