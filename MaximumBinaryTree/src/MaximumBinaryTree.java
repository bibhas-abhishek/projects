import java.util.LinkedList;
import java.util.Queue;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 30 Sep 2018
 * https://leetcode.com/problems/maximum-binary-tree/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/MaximumBinaryTree
 */

public class MaximumBinaryTree {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

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

    private static TreeNode constructMaximumBinaryTree(int[] arr) {
        return constructMaximumBinaryTree(arr, 0, arr.length - 1);
    }

    private static TreeNode constructMaximumBinaryTree(int[] arr, int l, int r) {
        if (l > r)
            return null;

        int maxIndex = getMaxIndex(arr, l, r);
        TreeNode root = new TreeNode(arr[maxIndex]);
        root.left = constructMaximumBinaryTree(arr, l, maxIndex - 1);
        root.right = constructMaximumBinaryTree(arr, maxIndex + 1, r);
        return root;
    }

    private static int getMaxIndex(int[] arr, int l, int r) {
        int maxIndex = l;
        for (int i = l; i <= r; i++) {
            if (arr[i] > arr[maxIndex])
                maxIndex = i;
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 6, 0, 5};
        TreeNode root = constructMaximumBinaryTree(arr);
        printLevelOrder(root);
    }

}
