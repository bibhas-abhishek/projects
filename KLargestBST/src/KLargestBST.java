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

        static int count = 0;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(4);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(8);
        KLargest(root, 2);
    }

    private static void KLargest(Node root, int i) {
        if (root == null || Node.count >= i)
            return;
        KLargest(root.right, i);
        Node.count++;
        if (Node.count == i) {
            System.out.print(root.data + " ");
            return;
        }
        KLargest(root.left, i);
    }

}
