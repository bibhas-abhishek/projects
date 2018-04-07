public class ChildSum {

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
        root.left = new Node(3);
        root.right = new Node(7);
        root.right.right = new Node(3);
        root.right.left = new Node(4);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        System.out.print(isChildSum(root));
    }

    private static boolean isChildSum(Node root) {
        if (root == null || (root.left == null && root.right == null))
            return true;

        int left = root.left != null ? root.left.data : 0;
        int right = root.right != null ? root.right.data : 0;
        return (left + right == root.data) && isChildSum(root.left) && isChildSum(root.right);
    }

}
