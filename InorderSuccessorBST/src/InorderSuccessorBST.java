/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 02 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/InorderSuccessorBST
 **/

public class InorderSuccessorBST {

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
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(14);
        root.left.left = new Node(6);
        root.left.right = new Node(9);
        root.right.left = new Node(11);
        root.right.right = new Node(15);
        root.right.left.right = new Node(12);
        root.right.right.right = new Node(16);
        inorderDFS(root);
        System.out.println();
        System.out.println(getInorderSuccessor(root, 6).data);
    }

    private static Node getInorderSuccessor(Node root, int val) {
        if (root == null)
            return null;

        Node current = findNode(root, val);
        if (current == null)
            return null;

        if (current.right != null) // right subtree exists
            return findMin(current.right);
        else {
            Node ancestor = root;
            Node successor = null;
            while (ancestor != current) { // find the deepest node for which the target node is in the left subtree
                if (val < ancestor.data) {
                    successor = ancestor;
                    ancestor = ancestor.left;
                } else
                    ancestor = ancestor.right;
            }
            return successor;
        }
    }

    private static void inorderDFS(Node root) {
        if (root == null)
            return;
        inorderDFS(root.left);
        System.out.print(root.data + " ");
        inorderDFS(root.right);
    }

    private static Node findNode(Node root, int val) {
        if (root == null)
            return null;

        if (root.data == val)
            return root;
        else if (val < root.data)
            return findNode(root.left, val);
        else
            return findNode(root.right, val);
    }

    private static Node findMin(Node root) {
        while (root.left != null)
            root = root.left;

        return root;
    }

}
