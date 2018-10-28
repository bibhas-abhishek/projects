import java.util.ArrayList;
import java.util.List;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 28 Oct 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/BinaryTreeInorderPreorder
 */

public class BinaryTreeInorderPreorder {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

    }

    private int index;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = 0;
        List<Integer> postorder = new ArrayList<>();
        TreeNode root = buildTree(preorder, inorder, 0, inorder.length - 1, postorder);
        System.out.print("Postorder: ");
        postorder.stream().mapToInt(i -> i).mapToObj(i -> i + " ").forEach(System.out::print);
        return root;
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int start, int end, List<Integer> postorder) {
        if (start > end)
            return null;

        int i;
        for (i = start; i <= end; i++) {
            if (preorder[index] == inorder[i])
                break;
        }

        TreeNode root = new TreeNode(preorder[index]);
        index += 1;
        root.left = buildTree(preorder, inorder, start, i - 1, postorder);
        root.right = buildTree(preorder, inorder, i + 1, end, postorder);
        postorder.add(root.val);
        return root;
    }

    public void inorderDFS(TreeNode root) {
        if (root == null)
            return;
        inorderDFS(root.left);
        System.out.print(root.val + " ");
        inorderDFS(root.right);
    }

    public static void main(String[] args) {
        BinaryTreeInorderPreorder obj = new BinaryTreeInorderPreorder();
        int inorder[] = {4, 2, 5, 1, 3, 6};
        int preorder[] = {1, 2, 4, 5, 3, 6};
        TreeNode root = obj.buildTree(preorder, inorder);
        System.out.print("\nInorder: ");
        obj.inorderDFS(root);
    }

}
