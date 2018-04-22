/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 21 Apr 2018
 * https://leetcode.com/problems/longest-univalue-path/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/LongestUnivaluePath
 **/

public class LongestUnivaluePath {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

    }

    private static int count;

    private static int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;

        int leftSubtreeCount = longestUnivaluePath(root.left);
        int rightSubtreeCount = longestUnivaluePath(root.right);

        int currentLeftCount = 0, currentRightCount = 0;
        if (root.left != null && root.left.val == root.val)
            currentLeftCount += leftSubtreeCount + 1;

        if (root.right != null && root.right.val == root.val)
            currentRightCount += rightSubtreeCount + 1;

        count = Math.max(count, currentLeftCount + currentRightCount);
        return Math.max(currentLeftCount, currentRightCount);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(4);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        longestUnivaluePath(root);
        System.out.println(count);
    }

}
