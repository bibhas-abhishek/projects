/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 07 Jun 2018
 * https://leetcode.com/problems/same-tree/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/SameTree
 **/

public class SameTree {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if (p != null && q != null) {
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else
            return false;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(4);
        root1.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(4);
        root2.right.right = new TreeNode(5);

        System.out.println(isSameTree(root1, root2));
    }

}
