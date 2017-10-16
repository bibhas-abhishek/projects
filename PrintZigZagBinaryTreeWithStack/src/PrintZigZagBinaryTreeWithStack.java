import java.util.Stack;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 16 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/PrintZigZagBinaryTreeWithStack
 */
public class PrintZigZagBinaryTreeWithStack {

    private static class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        printZigZgOrderWithStack(root);
    }

    private static void printZigZgOrderWithStack(Node root) {
        if (root == null)
            return;
        Stack<Node> leftToRight = new Stack<>();
        Stack<Node> rightToLeft = new Stack<>();
        rightToLeft.push(root);
        while (!leftToRight.isEmpty() || !rightToLeft.isEmpty()) {
            while (!rightToLeft.isEmpty()) {
                Node temp = rightToLeft.pop();
                System.out.print(temp.data + " ");

                if (temp.right != null)
                    leftToRight.push(temp.right);
                if (temp.left != null)
                    leftToRight.push(temp.left);
            }

            while (!leftToRight.isEmpty()) {
                Node temp = leftToRight.pop();
                System.out.print(temp.data + " ");

                if (temp.left != null)
                    rightToLeft.push(temp.left);
                if (temp.right != null)
                    rightToLeft.push(temp.right);

            }
        }
    }

}
