public class RecursiveLevelOrderTraversal {

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
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(8);
        root.right.right = new Node(15);
        root.right.left = new Node(12);
        root.right.right.left = new Node(14);
        printLevelOrder(root);
    }

    private static void printLevelOrder(Node root) {
        for (int i = 0; i <= height(root); i++) {
            printLevel(root, i);
        }
    }

    private static void printLevel(Node root, int level) {
        if (root == null)
            return;
        if (level == 0)
            System.out.print(root.data + " ");
        else {
            printLevel(root.left, level - 1);
            printLevel(root.right, level - 1);
        }
    }

    private static int height(Node root) {
        if (root == null)
            return -1;
        else
            return Math.max(height(root.left), height(root.right)) + 1;
    }

}
