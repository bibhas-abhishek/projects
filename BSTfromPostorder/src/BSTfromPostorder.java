/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 14 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/BSTfromPostorder
 **/

public class BSTfromPostorder {

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

    public TreeNode constructBST(int[] postorder) {
        index = postorder.length - 1;
        return constructBST(postorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        // return constructBST2(postorder, 0, postorder.length - 2);
    }

    private TreeNode constructBST(int[] postorder, int minValue, int maxValue) {
        if (index < 0)
            return null;

        int key = postorder[index];
        TreeNode root = null;
        if (key > minValue && key < maxValue) {
            root = new TreeNode(key);
            index -= 1;
            root.right = constructBST(postorder, key, maxValue);
            root.left = constructBST(postorder, minValue, key);
        }
        return root;
    }

    private TreeNode constructBST2(int[] postorder, int low, int high) {
        if (low > high || index < 0)
            return null;

        TreeNode root = new TreeNode(postorder[index]);
        index -= 1;
        int i;
        for (i = low; i < high; i++) {
            if (postorder[i] > root.val)
                break;
        }

        root.right = constructBST2(postorder, i, index);
        root.left = constructBST2(postorder, low, i - 1);
        return root;
    }

    public static void main(String[] args) {
        BSTfromPostorder obj = new BSTfromPostorder();
        int postorder[] = new int[]{1, 7, 5, 50, 40, 10};
        TreeNode root = obj.constructBST(postorder);
        obj.inorderDFS(root);
    }

}
