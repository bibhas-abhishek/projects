import java.util.LinkedList;
import java.util.Queue;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 18 Dec 2018
 * https://leetcode.com/problems/check-completeness-of-a-binary-tree/
 * https://github.com/bibhas-abhishek/projects/tree/master/CheckCompleteBinaryTree
 */

public class CheckCompleteBinaryTree {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    public boolean isCompleteTree(TreeNode root) {
        if (root == null)
            return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean foundNull = false;
        while (!queue.isEmpty()) {
            TreeNode n = queue.poll();
            if (n != null && foundNull)
                return false;

            if (n == null) {
                foundNull = true;
            } else {
                queue.offer(n.left);
                queue.offer(n.right);
            }
        }
        return true;
    }

}
