/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 29 Oct 2017
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/LeastCommonAncestor
 */
public class LeastCommonAncestor {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(15);
        root.right.left = new TreeNode(12);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(8);
        /* TreeNode result = leastCommonAncestor(root, 2, 12);
        System.out.println(result != null ? result.val : "No LCA"); */
        TreeNode n1 = root.right.right;
        TreeNode n2 = root.right.left;
        System.out.println(leastCommonAncestor(root, n1, n2).val);
    }

    private static TreeNode leastCommonAncestor(TreeNode root, int v1, int v2) {
        if (!covers(root, v1) || !covers(root, v2))
            return null;

        if (root == null || root.val == v1 || root.val == v2)
            return root;

        boolean isV1Left = covers(root.left, v1);
        boolean isV2left = covers(root.left, v2);
        if (isV1Left ^ isV2left)
            return root;
        else
            return isV1Left ? leastCommonAncestor(root.left, v1, v2) : leastCommonAncestor(root.right, v1, v2);
    }

    private static TreeNode leastCommonAncestor(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root == null || root == n1 || root == n2)
            return root;

        TreeNode left = leastCommonAncestor(root.left, n1, n2);
        TreeNode right = leastCommonAncestor(root.right, n1, n2);
        if (left != null && right != null)
            return root;

        return left != null ? left : right;
    }

    private static boolean covers(TreeNode root, int data) {
        if (root == null) return false;
        if (root.val == data) return true;
        return covers(root.left, data) || covers(root.right, data);
    }

}
