/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 16 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/PrintBinaryTreeZigZag
 */
public class PrintBinaryTreeZigZag {

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
        printZigZagOrder(root);
    }

    private static void printZigZagOrder(Node root) {
        boolean order = false;
        for (int i = 0; i <= height(root); i++) {
            printLevel(root, i, order);
            order = !order;
        }
    }

    private static void printLevel(Node root, int level, boolean order) {
        if (root == null)
            return;
        if (level == 0)
            System.out.print(root.data + " ");
        else if (!order) {
            printLevel(root.right, level - 1, order);
            printLevel(root.left, level - 1, order);
        } else {
            printLevel(root.left, level - 1, order);
            printLevel(root.right, level - 1, order);
        }
    }

    private static int height(Node root) {
        if (root == null)
            return -1;
        else
            return Math.max(height(root.left), height(root.right)) + 1;
    }

}
