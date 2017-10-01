public class SymmetricBinaryTree {

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
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        System.out.print(isSymmetric(root, root));
    }

    private static boolean isSymmetric(Node nodeA, Node nodeB) {
        if (nodeA == null && nodeB == null)
            return true;
        if (nodeA != null && nodeB != null) {
            if (nodeA.data == nodeB.data
                    && isSymmetric(nodeA.left, nodeB.right)
                    && isSymmetric(nodeA.right, nodeB.left))
                return true;
        }
        return false;
    }

}
