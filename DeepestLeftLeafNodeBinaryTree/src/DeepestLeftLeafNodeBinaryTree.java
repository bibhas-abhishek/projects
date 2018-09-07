/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 05 Sep 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/DeepestLeftLeafNodeBinaryTree
 */

public class DeepestLeftLeafNodeBinaryTree {

    private static class Node {

        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }

    }

    private static Node result;

    private static int maxDepth;

    private static void getDeepestLeftLeaf(Node root) {
        result = root;
        getDeepestLeftNodeUtil(root, 0, false);
    }

    private static void getDeepestLeftNodeUtil(Node root, int depth, boolean isLeft) {
        if (root == null)
            return;

        if (isLeft && root.left == null && root.right == null && depth > maxDepth) {
            maxDepth = depth;
            result = root;
        }

        getDeepestLeftNodeUtil(root.left, depth + 1, true);
        getDeepestLeftNodeUtil(root.right, depth + 1, false);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.right = new Node(7);
        root.right.right.right = new Node(8);
        root.right.left.right.left = new Node(9);
        root.right.right.right.right = new Node(10);
        getDeepestLeftLeaf(root);
        System.out.println(result.data);
    }

}
