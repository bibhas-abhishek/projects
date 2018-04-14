/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 14 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/BSTfromPreorder
 **/

public class BSTfromPreorder {

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

    private static Node constructBST(int[] preorder) {
        index = 0;
        // return constructBSTUtil(preorder, 1, preorder.length - 1);
        return constructBSTUOptUtil(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static Node constructBSTUOptUtil(int[] preorder, int minValue, int maxValue) {
        if (index >= preorder.length)
            return null;

        int key = preorder[index];
        Node root = null;
        if (key > minValue && key < maxValue) {
            root = new Node(preorder[index]);
            index += 1;
            root.left = constructBSTUOptUtil(preorder, minValue, root.data);
            root.right = constructBSTUOptUtil(preorder, root.data, maxValue);
        }
        return root;
    }

    private static Node constructBSTUtil(int[] preorder, int low, int high) {
        if (low > high || index >= preorder.length)
            return null;

        Node root = new Node(preorder[index]);
        index += 1;

        int i;
        for (i = low; i <= high; i++) {
            if (preorder[i] > root.data)
                break;
        }

        // found i as the index of first largest element greater than root
        root.left = constructBSTUtil(preorder, index, i - 1);
        root.right = constructBSTUtil(preorder, i, high);
        return root;
    }

    public static void main(String[] args) {
        int preorder[] = new int[]{10, 5, 1, 7, 40, 50};
        Node root = constructBST(preorder);
        inorderDFS(root);
    }

}
