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

    public int isChildSum(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }

        int leftSum = isChildSum(root.left);
        if (leftSum == Integer.MAX_VALUE) {
            return leftSum;
        }

        int rightSum = isChildSum(root.right);
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
        System.out.print(new IsChildSum().isChildSum(root) != Integer.MAX_VALUE);
    }
}
