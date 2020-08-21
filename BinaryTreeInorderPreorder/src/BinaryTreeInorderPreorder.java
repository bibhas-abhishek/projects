import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderPreorder {

    private static class TreeNode {

        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private int index;

    /*
    public void inorderDFS(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderDFS(root.left);
        System.out.print(root.val + " ");
        inorderDFS(root.right);
    }
     */

    private TreeNode solveUtil(int[] preorder, int[] inorder, int start, int end, List<Integer> postorder) {
        if (start > end) {
            return null;
        }

        int i;
        for (i = start; i <= end; i++) {
            if (preorder[index] == inorder[i]) {
                break;
            }
        }

        TreeNode root = new TreeNode(preorder[index]);
        index += 1;
        root.left = solveUtil(preorder, inorder, start, i - 1, postorder);
        root.right = solveUtil(preorder, inorder, i + 1, end, postorder);
        postorder.add(root.val);
        return root;
    }

    public TreeNode solve(int[] preorder, int[] inorder) {
        index = 0;
        List<Integer> postorder = new ArrayList<>();
        TreeNode root = solveUtil(preorder, inorder, 0, inorder.length - 1, postorder);
        System.out.print("Postorder: " + postorder);
        return root;
    }

    public static void main(String[] args) {
        BinaryTreeInorderPreorder object = new BinaryTreeInorderPreorder();
        int[] inorder = { 4, 2, 5, 1, 3, 6 };
        int[] preorder = { 1, 2, 4, 5, 3, 6 };
        object.solve(preorder, inorder);
    }
}
