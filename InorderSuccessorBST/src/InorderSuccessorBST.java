public class InorderSuccessorBST {

    private static class Node {

        int  data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return data + "";
        }
    }

    public void inorderDFS(Node root) {
        if (root == null) {
            return;
        }
        inorderDFS(root.left);
        System.out.print(root.data + " ");
        inorderDFS(root.right);
    }

    private Node findNode(Node root, int val) {
        if (root == null) {
            return null;
        }

        if (root.data == val) {
            return root;
        }
        return val <= root.data ? findNode(root.left, val) : findNode(root.right, val);
    }

    private Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public Node getInorderSuccessor(Node root, int val) {
        if (root == null) {
            return null;
        }

        Node node = findNode(root, val);
        if (node == null) {
            return null;
        }

        if (node.right != null) { // right subtree exists
            return findMin(node.right); // find min in right subtree
        }

        Node ptr = root;
        Node successor = null;
        while (ptr != node) { // find the last node for which the target node is in the left subtree
            if (val < ptr.data) {
                successor = ptr;
                ptr = ptr.left;
            }
            else {
                ptr = ptr.right;
            }
        }
        return successor;
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

        InorderSuccessorBST driver = new InorderSuccessorBST();
        System.out.print("Inorder Traversal: ");
        driver.inorderDFS(root);
        System.out.println();
        System.out.print("Inorder successor of 6: ");
        System.out.println(driver.getInorderSuccessor(root, 6));
    }
}
