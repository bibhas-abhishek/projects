import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 16 Oct 2018
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/BinaryTreeLevelOrderTraversal
 */

public class BinaryTreeLevelOrderTraversal {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

    }

    public void printLevelOrder(TreeNode root) {
        int height = getHeight(root);
        for (int i = 0; i <= height; i++) {
            printLevel(root, i);
        }
    }

    private void printLevel(TreeNode root, int level) {
        if (root == null)
            return;

        if (level == 0)
            System.out.print(root.val + " ");
        else {
            printLevel(root.left, level - 1);
            printLevel(root.right, level - 1);
        }
    }

    public void printLevelOrderWithQueue(TreeNode root) {
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

    private int getHeight(TreeNode root) {
        if (root == null)
            return -1;
        else
            return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            int i = queue.size();
            List<Integer> level = new ArrayList<>();
            while (i > 0) {
                TreeNode temp = queue.poll();
                level.add(temp.val);
                if (temp.left != null)
                    queue.offer(temp.left);

                if (temp.right != null)
                    queue.offer(temp.right);

                i -= 1;
            }
            result.add(level);
        }
        return result;
    }

    public List<List<Integer>> reverseLevelOrderDFS(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        addLevel(result, root, 0);
        return result;
    }

    private void addLevel(List<List<Integer>> result, TreeNode root, int level) {
        if (root == null)
            return;

        if (result.size() == level)
            result.add(0, new LinkedList<>());

        addLevel(result, root.left, level + 1);
        addLevel(result, root.right, level + 1);
        List<Integer> list = result.get(result.size() - level - 1);
        list.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(15);

        BinaryTreeLevelOrderTraversal obj = new BinaryTreeLevelOrderTraversal();
        obj.printLevelOrder(root);
        System.out.println();
        obj.printLevelOrderWithQueue(root);
        System.out.println();
        System.out.println(obj.levelOrder(root));
        System.out.println(obj.reverseLevelOrderDFS(root));
    }

}
