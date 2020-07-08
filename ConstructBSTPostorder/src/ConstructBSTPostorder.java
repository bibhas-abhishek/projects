/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 14 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/BSTfromPostorder
 **/

public class ConstructBSTPostorder {

    private static class TreeNode {

        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private int index;

    public void inorderDFS(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderDFS(root.left);
        System.out.print(root.val + " ");
        inorderDFS(root.right);
    }

    private TreeNode constructBSTUtilOptimised(int[] postorder, int minValue, int maxValue) {
        if (index < 0) {
            return null;
        }

        int key = postorder[index];
        TreeNode root = null;
        if (key > minValue && key < maxValue) {
            root = new TreeNode(key);
            index -= 1;
            root.right = constructBSTUtilOptimised(postorder, key, maxValue);
            root.left = constructBSTUtilOptimised(postorder, minValue, key);
        }
        return root;
    }

    private TreeNode constructBSTUtilNaive(int[] postorder, int low, int high) {
        if (low > high || index < 0) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[index]);
        index -= 1;
        int i;
        for (i = low; i < high; i++) {
            if (postorder[i] > root.val) {
                break;
            }
        }
        root.right = constructBSTUtilNaive(postorder, i, index);
        root.left = constructBSTUtilNaive(postorder, low, i - 1);
        return root;
    }

    public TreeNode constructBSTUtil(int[] postorder) {
        index = postorder.length - 1;
        return constructBSTUtilNaive(postorder, 0, postorder.length - 2);
        // return constructBSTUtilOptimised(postorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        ConstructBSTPostorder obj = new ConstructBSTPostorder();
        int[] postorder = new int[] { 1, 7, 5, 50, 40, 10 };
        TreeNode root = obj.constructBSTUtil(postorder);
        obj.inorderDFS(root);
    }
}
