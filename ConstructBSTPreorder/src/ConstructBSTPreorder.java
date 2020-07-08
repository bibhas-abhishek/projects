/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 14 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/BSTfromPreorder
 **/

public class ConstructBSTPreorder {

    private static class TreeNode {

        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private int index;

    private void inorderDFS(TreeNode root) {
        if (root == null)
            return;
        inorderDFS(root.left);
        System.out.print(root.val + " ");
        inorderDFS(root.right);
    }

    private TreeNode constructBSTUtilOptimised(int[] preorder, int minValue, int maxValue) {
        if (index >= preorder.length) {
            return null;
        }

        int key = preorder[index];
        TreeNode root = null;
        if (key > minValue && key < maxValue) {
            root = new TreeNode(key);
            index += 1;
            root.left = constructBSTUtilOptimised(preorder, minValue, key);
            root.right = constructBSTUtilOptimised(preorder, key, maxValue);
        }
        return root;
    }

    public TreeNode constructBSTUtilNaive(int[] preorder, int low, int high) {
        if (low > high || index >= preorder.length) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[index]);
        index += 1;
        int i;
        for (i = low; i <= high; i++) {
            if (preorder[i] > root.val) {
                break;
            }
        }
        root.left = constructBSTUtilNaive(preorder, index, i - 1);
        root.right = constructBSTUtilNaive(preorder, i, high);
        return root;
    }

    public TreeNode constructBST(int[] preorder) {
        index = 0;
        // return constructBSTUtilNaive(preorder, 1, preorder.length - 1);
        return constructBSTUtilOptimised(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        ConstructBSTPreorder obj = new ConstructBSTPreorder();
        int[] preorder = new int[] { 10, 5, 1, 7, 40, 50 };
        TreeNode root = obj.constructBST(preorder);
        obj.inorderDFS(root);
    }
}
