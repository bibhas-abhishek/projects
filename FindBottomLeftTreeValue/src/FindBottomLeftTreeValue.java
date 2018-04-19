/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 19 Apr 2018
 * https://leetcode.com/problems/find-bottom-left-tree-value/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/FindBottomLeftTreeValue
 **/

public class FindBottomLeftTreeValue {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        System.out.println(findBottomLeftValue(root));
    }

    private static int findBottomLeftValue(TreeNode root) {
        return findBottomLeftValue(root, getHeight(root)).val;
    }

    private static TreeNode findBottomLeftValue(TreeNode root, int height) {
        if (root == null)
            return null;

        if (height == 0)
            return root;

        TreeNode res = findBottomLeftValue(root.left, height - 1);
        if (res != null)
            return res;
        return findBottomLeftValue(root.right, height - 1);
    }

    private static int getHeight(TreeNode root) {
        if (root == null)
            return -1;

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

}
