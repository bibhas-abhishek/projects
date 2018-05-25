import java.util.LinkedList;
import java.util.Queue;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 06 May 2018
 * https://leetcode.com/problems/binary-tree-pruning/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/BinaryTreePruning
 **/

public class BinaryTreePruning {

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
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        printLevelOrder(root);
        root = pruneTree(root);
        System.out.println();
        printLevelOrder(root);
    }

    private static void inorderDFS(TreeNode root) {
        if (root == null)
            return;
        inorderDFS(root.left);
        System.out.print(root.val + " ");
        inorderDFS(root.right);
    }

    private static void printLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            System.out.print(queue.peek().val + " ");
            TreeNode temp = queue.poll();
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }
    }

    private static TreeNode pruneTree(TreeNode root) {
        return !containsOne(root) ? null : root;
    }

    private static boolean containsOne(TreeNode root) {
        if (root == null)
            return false;

        boolean leftRes = containsOne(root.left);
        boolean rightRes = containsOne(root.right);
        if (!leftRes)
            root.left = null;

        if (!rightRes)
            root.right = null;

        return root.val == 1 || leftRes || rightRes;
    }

}
