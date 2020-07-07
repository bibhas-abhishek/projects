/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 30 Oct 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/ChildSum
 */

public class IsChildSum {

    private static class TreeNode {

        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public boolean isChildSum(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        int left = root.left != null ? root.left.val : 0;
        int right = root.right != null ? root.right.val : 0;
        return isChildSum(root.left) && isChildSum(root.right) && (left + right == root.val);
    }

    public int isChildSumBottomUp(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }

        int leftSum = isChildSumBottomUp(root.left);
        if (leftSum == Integer.MAX_VALUE) {
            return leftSum;
        }

        int rightSum = isChildSumBottomUp(root.right);
        if (rightSum == Integer.MAX_VALUE) {
            return rightSum;
        }

        if (root.val != leftSum + rightSum) {
            return Integer.MAX_VALUE;
        }
        return root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        System.out.println(new IsChildSum().isChildSum(root));
        System.out.print(new IsChildSum().isChildSumBottomUp(root) != Integer.MAX_VALUE);
    }
}
