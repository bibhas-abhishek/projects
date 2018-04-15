import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 15 Apr 2018
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/FindLargestValueinEachTreeRow
 **/

public class FindLargestValueinEachTreeRow {

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
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        System.out.println(largestValues(root));
    }

    private static List<Integer> largestValues(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelMax = Integer.MIN_VALUE;
            int i = queue.size();
            while (i > 0) {
                TreeNode temp = queue.poll();
                i -= 1;

                if (temp.val > levelMax)
                    levelMax = temp.val;

                if (temp.left != null)
                    queue.offer(temp.left);

                if (temp.right != null)
                    queue.offer(temp.right);
            }
            result.add(levelMax);
        }
        return result;
    }

}
