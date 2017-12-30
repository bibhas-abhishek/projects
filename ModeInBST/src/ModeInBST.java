/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 26 Dec 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/ModeInBST/
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/description/
 **/

public class ModeInBST {


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
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
        inorderDFS(root);
    }

    private static void inorderDFS(Node root) {
        if (root == null)
            return;
        inorderDFS(root.left);

        inorderDFS(root.right);
    }

    private int[] BSTMode(Node root) {
        if(ro)
    }

}
