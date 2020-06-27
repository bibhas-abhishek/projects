/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 07 Sep 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/SymmetricBinaryTree
 */

public class SymmetricBinaryTree {

    private static class Node {

        int  data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private static boolean isSymmetric(Node nodeA, Node nodeB) {
        if (nodeA == null && nodeB == null)
            return true;

        if (nodeA != null && nodeB != null) {
            return nodeA.data == nodeB.data && isSymmetric(nodeA.left, nodeB.right)
                    && isSymmetric(nodeA.right, nodeB.left);
        }
        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        System.out.print(isSymmetric(root, root));
    }
}
