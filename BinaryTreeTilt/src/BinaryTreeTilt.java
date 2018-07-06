/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 22 Jun 2018
 * https://leetcode.com/problems/binary-tree-tilt/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/BinaryTreeTilt
 **/

public class BinaryTreeTilt {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

    }

    private static int result = 0;

    private static int findTilt(TreeNode root) {
        findTiltHelper(root);
        return result;
    }

    private static int findTiltHelper(TreeNode root) {
        if (root == null)
            return 0;

        int left = findTiltHelper(root.left);
        int right = findTiltHelper(root.right);
        result += Math.abs(left - right);
        return left + right + root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        System.out.println(findTilt(root));
    }

}
