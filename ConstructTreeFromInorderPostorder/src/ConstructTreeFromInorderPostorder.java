/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 15 Apr 2018
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/ConstructTreeFromInorderPostorder
 **/

public class ConstructTreeFromInorderPostorder {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

    }

    private static int index;

    private static TreeNode buildTree(int[] postorder, int[] inorder) {
        index = postorder.length - 1;
        return buildTree(postorder, inorder, 0, inorder.length - 1);
    }

    private static TreeNode buildTree(int[] postorder, int[] inorder, int start, int end) {
        if (start > end)
            return null;

        int i;
        for (i = start; i <= end; i++) {
            if (postorder[index] == inorder[i])
                break;
        }

        TreeNode root = new TreeNode(postorder[index]);
        index -= 1;
        root.right = buildTree(postorder, inorder, i + 1, end);
        root.left = buildTree(postorder, inorder, start, i - 1);
        return root;
    }

}
