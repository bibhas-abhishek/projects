/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 06 Oct 2018
 * https://leetcode.com/problems/increasing-order-search-tree/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/IncreasingOrderSearchTree
 */

public class IncreasingOrderSearchTree {

    private TreeNode temp = new TreeNode(Integer.MIN_VALUE);

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    public TreeNode increasingBST(TreeNode root) {
        TreeNode res = temp;
        inorderBuild(root);
        return res.right;
    }

    private void inorderBuild(TreeNode root) {
        if (root == null)
            return;

        inorderBuild(root.left);
        root.left = null;
        temp.right = root;
        temp = root;
        inorderBuild(root.right);
    }

}
