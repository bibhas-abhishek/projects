/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 14 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/BSTfromPostorder
 **/

public class BSTfromPostorder {

    private static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }

    }

    private static int index;

    private static void inorderDFS(Node root) {
        if (root == null)
            return;
        inorderDFS(root.left);
        System.out.print(root.data + " ");
        inorderDFS(root.right);
    }

    private static Node constructBST(int[] postorder) {
        index = postorder.length - 1;
        // return constructBSTUtil(postorder, 0, postorder.length - 2);
        return constructBSTUOptUtil(postorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static Node constructBSTUtil(int[] postorder, int low, int high) {
        if (low > high || index < 0)
            return null;

        Node root = new Node(postorder[index]);
        index -= 1;

        int i;
        for (i = low; i < high; i++) {
            if (postorder[i] > root.data)
                break;
        }

        // found i as the index of first largest element greater than root
        root.right = constructBSTUtil(postorder, i, index);
        root.left = constructBSTUtil(postorder, low, i - 1);
        return root;
    }

    private static Node constructBSTUOptUtil(int[] postorder, int minValue, int maxValue) {
        if (index < 0)
            return null;

        int key = postorder[index];
        Node root = null;
        if (key > minValue && key < maxValue) {
            root = new Node(postorder[index]);
            index -= 1;
            root.right = constructBSTUOptUtil(postorder, root.data, maxValue);
            root.left = constructBSTUOptUtil(postorder, minValue, root.data);
        }
        return root;
    }

    public static void main(String[] args) {
        int postorder[] = new int[]{1, 7, 5, 50, 40, 10};
        Node root = constructBST(postorder);
        inorderDFS(root);
    }

}
