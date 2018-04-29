import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 16 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/RecursiveLevelOrderTraversal
 */
public class RecursiveLevelOrderTraversal {

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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(15);
        printLevelOrder(root);
        System.out.println();
        printLevelOrderWithQueue(root);
        System.out.println();
        System.out.println(levelOrder(root));
    }

    private static void printLevelOrder(TreeNode root) {
        for (int i = 0; i <= height(root); i++) {
            printLevel(root, i);
        }
    }

    private static void printLevel(TreeNode root, int level) {
        if (root == null)
            return;
        if (level == 0)
            System.out.print(root.val + " ");
        else {
            printLevel(root.left, level - 1);
            printLevel(root.right, level - 1);
        }
    }

    private static void printLevelOrderWithQueue(TreeNode root) {
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

    private static int height(TreeNode root) {
        if (root == null)
            return -1;
        else
            return Math.max(height(root.left), height(root.right)) + 1;
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
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

}
