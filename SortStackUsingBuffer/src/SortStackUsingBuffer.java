import java.util.Stack;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 21 Mar 2018
 **/

public class SortStackUsingBuffer {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(10);
        stack.add(2);
        stack.add(9);
        stack.add(7);
        stack = sortStack(stack);
        for (Integer key : stack) {
            System.out.print(key + " ");
        }
    }

    private static Stack<Integer> sortStack(Stack<Integer> stack) {
        Stack<Integer> buffer = new Stack<>();
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            while (!buffer.isEmpty() && buffer.peek() > temp)
                stack.push(buffer.pop());
            buffer.push(temp);
        }
        return buffer;
    }

}
