/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 26 May 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/NextGreaterElement
 **/

import java.util.Stack;

public class NextGreaterElement {

    private static void nextGreaterElement(int[] array) {
        Stack<Integer> stack = new Stack<>();
        stack.push(array[0]);
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int top = stack.pop();
            if (current < top)
                stack.push(top);        // push back popped stack top if current array element is less than it
            else {
                while (current > top) {     // keep removing elements from the stack if current > stackTop
                    System.out.println(top + "->" + current);
                    if (stack.isEmpty())
                        break;
                    top = stack.pop();      // continue if the stack tops are lesser than the current scanned element
                }
            }
            stack.push(current);        // push the current scanned array element
        }

        while (!stack.isEmpty())
            System.out.println(stack.pop() + "->" + "-1");
    }

    public static void main(String[] args) {
        int[] array = {4, 5, 2, 25};
        nextGreaterElement(array);
    }

}
