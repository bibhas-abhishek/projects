/*https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/*/

public class MaxSumBSTInBinaryTree {

    private static class TreeNode {

        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    private static class Wrapper {

        int     min;
        int     max;
        int     sum;
        boolean isBST;

        Wrapper() {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            sum = 0;
            isBST = true;
        }
    }

    public TreeNode buildTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(20);
        root.right.right.left = new TreeNode(4);
        root.right.right.right = new TreeNode(6);
        return root;
    }

    private Wrapper maxSumBSTUtil(TreeNode root) {
        if (root == null) {
            return new Wrapper();
        }

        Wrapper left = maxSumBSTUtil(root.left);
        Wrapper right = maxSumBSTUtil(root.right);
        Wrapper wrapper = new Wrapper();
        if (!left.isBST || !right.isBST || root.val < left.max || root.val >= right.min) {
            wrapper.isBST = false;
            wrapper.sum = Math.max(left.sum, right.sum);
            return wrapper;
        }

        wrapper.isBST = true;
        wrapper.sum = left.sum + right.sum + root.val;
        wrapper.min = root.left == null ? root.val : left.min;
        wrapper.max = root.right == null ? root.val : right.max;
        return wrapper;
    }

    public int maxSumBST(TreeNode root) {
        return maxSumBSTUtil(root).sum;
    }

    public static void main(String[] args) {
        MaxSumBSTInBinaryTree obj = new MaxSumBSTInBinaryTree();
        TreeNode root = obj.buildTree();
        System.out.println(obj.maxSumBST(root));
    }
}
