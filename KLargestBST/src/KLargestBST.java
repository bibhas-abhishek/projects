/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 09 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/KLargestBST
 */
public class KLargestBST {

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

    static int count = 1;

    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.right = new Node(12);
        root.right.left = new Node(7);
        inorderDFS(root);
        System.out.println();
        System.out.println(KLargest(root, 7).data);
    }

    private static void inorderDFS(Node root) {
        if (root == null)
            return;
        inorderDFS(root.left);
        System.out.print(root.data + " ");
        inorderDFS(root.right);
    }

    private static Node KLargest(Node root, int k) {
        if (root == null)
            return null;
        Node res = KLargest(root.right, k);
        if (res != null)
            return res;
        if (count == k)
            return root;
        count += 1;
        return KLargest(root.left, k);
    }

}
