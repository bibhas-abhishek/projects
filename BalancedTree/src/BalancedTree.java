/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 26 Mar 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/BalancedTree
 **/

public class BalancedTree {

    private static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
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
        root.left.left.left = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        inorderDFS(root);
        System.out.println("Method1: " + isBalancedInferior(root));
        System.out.println("Method2 : " + String.valueOf(isBalancedSuperior(root) != Integer.MAX_VALUE));
    }

    private static void inorderDFS(Node root) {
        if (root == null)
            return;
        inorderDFS(root.left);
        System.out.print(root.data + " ");
        inorderDFS(root.right);
    }

    private static boolean isBalancedInferior(Node root) {
        if (root == null)
            return true;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if ((Math.abs(leftHeight - rightHeight) <= 1) && isBalancedInferior(root.left) && isBalancedInferior(root.right))
            return true;
        else
            return false;
    }

    private static int isBalancedSuperior(Node root) {
        if (root == null)
            return 0;

        int leftHeight = isBalancedSuperior(root.left);
        if (leftHeight == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        int rightHeight = isBalancedSuperior(root.right);
        if (rightHeight == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        int diff = Math.abs(leftHeight - rightHeight);
        if (diff <= 1)
            return Math.max(leftHeight, rightHeight) + 1;
        else return Integer.MAX_VALUE;
    }

    private static int getHeight(Node root) {
        if (root == null)
            return -1;

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

}
