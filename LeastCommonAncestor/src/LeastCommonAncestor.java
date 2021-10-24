public class LeastCommonAncestor {

    private static class TreeNode {
        int      val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    private TreeNode leastCommonAncestor(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root == null || root == n1 || root == n2) {
            return root;
        }

        TreeNode left = leastCommonAncestor(root.left, n1, n2);
        TreeNode right = leastCommonAncestor(root.right, n1, n2);
        // getting not-null from both side. return root as ancestor
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        LeastCommonAncestor driver = new LeastCommonAncestor();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(15);
        root.right.left = new TreeNode(12);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(8);

        TreeNode n1 = root.right.right;
        TreeNode n2 = root.right.left;
        System.out.println(driver.leastCommonAncestor(root, n1, n2));
    }
}
