import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int index = 0; index < t; index++) {
            String s = in.next();
            String result = isBalanced(s);
            System.out.println(result);
        }
        in.close();
    }

    private static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        Boolean flag = true;
        int i = 0;
        while (i < s.length() && flag) {
            Character element = s.charAt(i);
            if (element == '(' || element == '{' || element == '[')
                stack.push(element);
            else {
                if (stack.isEmpty() || element != returnMatchedBracket(stack.pop())) {
                    flag = false;
                    break;
                }
            }
            i++;
        }
        return flag && stack.isEmpty() ? "YES" : "NO";
    }

    private static Character returnMatchedBracket(Character c) {
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

}
