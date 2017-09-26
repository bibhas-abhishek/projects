public class BSTFromSortedArray {

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
        int[] array = new int[]{1, 2, 3, 4, 7, 8, 9};
        Node root = createBSTFromSortedArray(array, 0, array.length - 1);
        preOrderTraversal(root);
    }

    private static void preOrderTraversal(Node root) {
        if (root == null)
            return;
        preOrderTraversal(root.left);
        System.out.print(root.data + " ");
        preOrderTraversal(root.right);
    }

    private static Node createBSTFromSortedArray(int array[], int left, int right) {
        if (left > right)
            return null;
        int mid = (left + right) / 2;
        Node node = new Node(array[mid]);
        node.left = createBSTFromSortedArray(array, left, mid - 1);
        node.right = createBSTFromSortedArray(array, mid + 1, right);
        return node;
    }

}
