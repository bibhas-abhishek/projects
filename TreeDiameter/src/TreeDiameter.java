/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 01 Apr 2018
 * https://leetcode.com/problems/diameter-of-binary-tree/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/TreeDiameter
 **/

public class TreeDiameter {

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
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        inorderDFS(root);
        System.out.println();
        System.out.println(diameter(root));
    }

    private static void inorderDFS(Node root) {
        if (root == null)
            return;
        inorderDFS(root.left);
        System.out.print(root.data + " ");
        inorderDFS(root.right);
    }

    private static int diameter(Node root) {
        if (root == null)
            return 0;
        int maxDepthSums = getHeight(root.left) + getHeight(root.right);
        int leftHeight = diameter(root.left);
        int rightHeight = diameter(root.right);
        return Math.max(maxDepthSums, Math.max(leftHeight, rightHeight));
    }

    private static int getHeight(Node root) {
        if (root == null)
            return 0;
        else
            return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

}
