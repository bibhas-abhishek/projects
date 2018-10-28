/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 28 Oct 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/CompleteTreePreorderPostorder
 */

public class CompleteTreePreorderPostorder {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

    }

    private int index;

    public TreeNode constructTree(int[] preorder, int[] postorder) {
        index = 0;
        return constructTree(preorder, postorder, 0, postorder.length - 1);
    }

    private TreeNode constructTree(int[] preorder, int[] postorder, int start, int end) {
        if (start > end || index >= preorder.length)
            return null;

        TreeNode root = new TreeNode(preorder[index]);
        index += 1;

        if (start == end || index >= preorder.length)
            return root;

        // search element in preorder is the root of left subtree
        // search in postorder -> index
        // l -> index = left subtree, index + 1 -> h = right subtree
        int i;
        for (i = start; i <= end; i++) {
            if (preorder[index] == postorder[i])
                break;
        }

        if (i <= end) {
            root.left = constructTree(preorder, postorder, start, i);
            root.right = constructTree(preorder, postorder, i + 1, end);
        }
        return root;
    }

    public void preorderDFS(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.val + " ");
        preorderDFS(root.left);
        preorderDFS(root.right);
    }

    public static void main(String[] args) {
        CompleteTreePreorderPostorder obj = new CompleteTreePreorderPostorder();
        int preorder[] = {1, 2, 4, 8, 9, 5, 3, 6, 7};
        int postorder[] = {8, 9, 4, 5, 2, 6, 7, 3, 1};
        TreeNode root = obj.constructTree(preorder, postorder);
        obj.preorderDFS(root);
    }

}
