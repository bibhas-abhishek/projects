/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 14 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/FixSwappedNodesBST
 **/

public class FixSwappedNodesBST {

    private static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }

    }

    private Node first = null, second = null, prev = null, firstNext = null;

    private void inorderDFS(Node root) {
        if (root == null)
            return;

        inorderDFS(root.left);
        System.out.print(root.data + " ");
        inorderDFS(root.right);
    }

    public Node fixBST(Node root) {
        findSwappedNodes(root);
        if (first != null && second != null)
            swap(first, second);

        if (second == null && first != null)
            swap(first, firstNext);

        return root;
    }

    private void findSwappedNodes(Node root) {
        if (root == null)
            return;

        findSwappedNodes(root.left);
        if (prev != null && prev.data > root.data) {
            if (first == null) {
                firstNext = root;
                first = prev;
            } else
                second = root;
        }
        prev = root;
        findSwappedNodes(root.right);
    }

    private void swap(Node first, Node second) {
        int temp = first.data;
        first.data = second.data;
        second.data = temp;
    }

    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(10);
        root.right = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.right = new Node(12);
        root.right.left = new Node(7);

        FixSwappedNodesBST obj = new FixSwappedNodesBST();
        obj.inorderDFS(root);
        System.out.println();
        root = obj.fixBST(root);
        obj.inorderDFS(root);
    }

}
