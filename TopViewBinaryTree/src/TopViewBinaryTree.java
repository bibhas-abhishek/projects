import java.util.*;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 05 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/TopViewBinaryTree
 **/

public class TopViewBinaryTree {

    private static class TreeNode {

        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    private static class QueueNode {

        TreeNode treeNode;
        int hd;

        QueueNode(TreeNode treeNode, int hd) {
            this.treeNode = treeNode;
            this.hd = hd;
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        printTopView(root, 0);
    }

    private static void printTopView(TreeNode root, int hd) {
        if (root == null)
            return;

        Queue<QueueNode> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.add(new QueueNode(root, hd));

        while (!queue.isEmpty()) {
            QueueNode queueNode = queue.poll();
            TreeNode treeNode = queueNode.treeNode;
            int hDist = queueNode.hd;
            if (!set.contains(hDist)) {
                System.out.print(treeNode.data + " ");
                set.add(hDist);
            }

            if (treeNode.left != null)
                queue.add(new QueueNode(treeNode.left, hDist - 1));

            if (treeNode.right != null)
                queue.add(new QueueNode(treeNode.right, hDist + 1));
        }
    }

}
