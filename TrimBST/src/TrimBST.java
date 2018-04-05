/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 05 Apr 2018
 * https://leetcode.com/problems/trim-a-binary-search-tree/
 * https://github.com/bibhas-abhishek/projects/tree/master/TrimBST
 **/

public class TrimBST {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(-13);
        root.right = new TreeNode(14);
        root.left.right = new TreeNode(-8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(15);
        root.right.left.left = new TreeNode(7);
        inorderDFS(root);
        root = trimBST(root, -10, 13);
        System.out.println();
        inorderDFS(root);
    }

    private static TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null)
            return null;

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        if (root.val < L)
            return root.right;
        else if (root.val > R)
            return root.left;

        return root;
    }

    private static void inorderDFS(TreeNode root) {
        if (root == null)
            return;
        inorderDFS(root.left);
        System.out.print(root.val + " ");
        inorderDFS(root.right);
    }

}
