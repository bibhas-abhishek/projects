import java.util.Scanner;
import java.util.Stack;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 19 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/TwoStackQueue
 * https://www.hackerrank.com/challenges/queue-using-two-stacks/problem
 */
public class TwoStackQueue {

    private static class Queue<T> {

        private Stack<T> newStack;
        private Stack<T> oldStack;

        public Queue() {
            newStack = new Stack<>();
            oldStack = new Stack<>();
        }

        public void enqueue(T element) {
            newStack.push(element);
        }

        public T peek() {
            shiftElements();
            return oldStack.peek();
        }

        public void pop() {
            shiftElements();
            oldStack.pop();
        }

        private void shiftElements() {
            if (oldStack.isEmpty()) {
                while (!newStack.isEmpty())
                    oldStack.push(newStack.pop());
            }
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = Integer.parseInt(in.nextLine());
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < q; i++) {
            String[] input = in.nextLine().split(" ");
            int operation = Integer.parseInt(input[0]);
            switch (operation) {
                case 1:
                    queue.enqueue(Integer.parseInt(input[1]));
                    break;
                case 2:
                    queue.pop();
                    break;
                case 3:
                    System.out.println(queue.peek());
                    break;
            }
        }
    }

}
