/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 08 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/ConvertToChildSum
 **/

public class ConvertToChildSum {

    private static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }

    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(7);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(1);
        root.right.right = new Node(30);
        inorderDFS(root);
        System.out.println();
        root = convertToChildCum(root);
        inorderDFS(root);
    }

    private static void inorderDFS(Node root) {
        if (root == null)
            return;
        inorderDFS(root.left);
        System.out.print(root.data + " ");
        inorderDFS(root.right);
    }

    private static Node convertToChildCum(Node root) {
        if (root == null || (root.left == null && root.right == null))
            return root;

        root.left = convertToChildCum(root.left);
        root.right = convertToChildCum(root.right);

        int leftData = root.left == null ? 0 : root.left.data;
        int rightData = root.right == null ? 0 : root.right.data;
        int diff = leftData + rightData - root.data;

        if (diff > 0)
            root.data += diff;
        else
            root = incrementSubtree(root, -diff);
        return root;
    }

    private static Node incrementSubtree(Node root, int diff) {
        if (root == null)
            return null;

        if (root.left != null) {
            root.left.data += diff;
            root.left = incrementSubtree(root.left, diff);
        } else if (root.right != null) {
            root.right.data += diff;
            root.right = incrementSubtree(root.right, diff);
        }
        return root;
    }

}
