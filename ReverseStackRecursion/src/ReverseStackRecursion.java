/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- projects: ReverseStackRecursion
*- 17 Nov 2021 4:54 PM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
* https://www.geeksforgeeks.org/reverse-a-stack-using-recursion
-------------------------------------------*/

import java.util.Stack;

public class ReverseStackRecursion {

    private static Stack<Integer> stack = new Stack<>();

    public void reverseStack() {
        if (stack.size() > 0) {
            int x = stack.pop();
            reverseStack();
            pushBack(x);
        }
    }

    private void pushBack(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
        } else {
            int y = stack.peek();
            stack.pop();
            pushBack(x);
            stack.push(y);
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i < 6; i++) {
            stack.add(i);
        }
        ReverseStackRecursion driver = new ReverseStackRecursion();
        driver.reverseStack();
        System.out.println(stack);
    }
}
