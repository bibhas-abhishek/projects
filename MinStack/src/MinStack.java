import java.util.Stack;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 25 Mar 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/MinStack
 **/

public class MinStack {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public MinStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        if (x < min())
            s2.push(x);

        s1.push(x);
    }

    public void pop() {
        int pop = s1.pop();
        if (pop == s2.peek())
            s2.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return s2.peek();
    }

    private int min() {
        if (s2.isEmpty())
            return Integer.MAX_VALUE;

        return s2.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }

}
