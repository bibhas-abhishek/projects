import java.util.Scanner;
import java.util.Stack;

public class MaximumElement {

    private static class StackNode {

        private int element;
        private int levelMaximum;

        public StackNode(int element, int levelMaximum) {
            this.element = element;
            this.levelMaximum = levelMaximum;
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Stack<StackNode> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int operation = in.nextInt();
            switch (operation) {
                case 1:
                    int operand = in.nextInt();
                    //maintain index of maximum element at every level
                    int index = stack.isEmpty() ? 0 : (operand > stack.get(
                            stack.peek().levelMaximum).element ? stack.size() : stack.peek().levelMaximum);
                    stack.push(new StackNode(operand, index));
                    break;
                case 2:
                    if (!stack.isEmpty())
                        stack.pop();
                    break;
                case 3:
                    System.out.println(stack.get(stack.peek().levelMaximum).element);
                    break;

            }
        }
    }

}
