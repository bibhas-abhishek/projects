/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 25 Dec 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/InvertBinaryTree/
 **/

public class InvertBinaryTree {

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
        inorderDFS(root);
        System.out.println();
        invert(root);
        inorderDFS(root);

    }

    private static void inorderDFS(Node root) {
        if (root == null)
            return;
        inorderDFS(root.left);
        System.out.print(root.data + " ");
        inorderDFS(root.right);
    }

    private static Node invert(Node root) {
        if (root == null)
            return null;
        invert(root.left);
        invert(root.right);
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

}
