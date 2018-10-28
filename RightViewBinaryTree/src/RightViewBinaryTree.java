import java.util.LinkedList;
import java.util.Queue;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 28 Oct 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/RightViewBinaryTree
 */

public class RightViewBinaryTree {

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

    public void printRightView(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                if (i == 0)
                    System.out.print(t.val + " ");

                if (t.right != null)
                    queue.offer(t.right);

                if (t.left != null)
                    queue.offer(t.left);
            }
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
        root.right.right.left = new TreeNode(14);
        new RightViewBinaryTree().printRightView(root);
    }

}
