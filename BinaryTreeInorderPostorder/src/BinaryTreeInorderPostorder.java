/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 28 Oct 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/BinaryTreeInorderPostorder
 */

public class BinaryTreeInorderPostorder {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

    }

    private int index;

    public TreeNode buildTree(int[] postorder, int[] inorder) {
        index = postorder.length - 1;
        return buildTree(postorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] postorder, int[] inorder, int start, int end) {
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

    public void preorderTraversal(TreeNode node) {
        if (node == null)
            return;

        System.out.print(node.val + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    public static void main(String[] args) {
        BinaryTreeInorderPostorder obj = new BinaryTreeInorderPostorder();
        int[] inorder = new int[]{4, 8, 2, 5, 1, 6, 3, 7};
        int[] postorder = new int[]{8, 4, 5, 2, 6, 7, 3, 1};
        TreeNode root = obj.buildTree(postorder, inorder);
        obj.preorderTraversal(root);
    }

}
