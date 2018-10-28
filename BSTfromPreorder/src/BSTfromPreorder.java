/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 14 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/BSTfromPreorder
 **/

public class BSTfromPreorder {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

    }

    private int index;

    public void inorderDFS(TreeNode root) {
        if (root == null)
            return;
        inorderDFS(root.left);
        System.out.print(root.val + " ");
        inorderDFS(root.right);
    }

    public TreeNode constructBST(int[] preorder) {
        index = 0;
        return constructBST(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        // return constructBST2(preorder, 1, preorder.length - 1);
    }

    private TreeNode constructBST(int[] preorder, int minValue, int maxValue) {
        if (index >= preorder.length)
            return null;

        int key = preorder[index];
        TreeNode root = null;
        if (key > minValue && key < maxValue) {
            root = new TreeNode(key);
            index += 1;
            root.left = constructBST(preorder, minValue, key);
            root.right = constructBST(preorder, key, maxValue);
        }
        return root;
    }

    public TreeNode constructBST2(int[] preorder, int low, int high) {
        if (low > high || index >= preorder.length)
            return null;

        TreeNode root = new TreeNode(preorder[index]);
        index += 1;
        int i;
        for (i = low; i <= high; i++) {
            if (preorder[i] > root.val)
                break;
        }

        root.left = constructBST2(preorder, index, i - 1);
        root.right = constructBST2(preorder, i, high);
        return root;
    }

    public static void main(String[] args) {
        BSTfromPreorder obj = new BSTfromPreorder();
        int preorder[] = new int[]{10, 5, 1, 7, 40, 50};
        TreeNode root = obj.constructBST(preorder);
        obj.inorderDFS(root);
    }

}
