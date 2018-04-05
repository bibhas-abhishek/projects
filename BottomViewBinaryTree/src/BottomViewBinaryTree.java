import java.util.*;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 05 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/BottomViewBinaryTree
 **/

public class BottomViewBinaryTree {

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

        public QueueNode(TreeNode treeNode, int hd) {
            this.treeNode = treeNode;
            this.hd = hd;
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.right.right = new TreeNode(8);

        Map<Integer, Integer> treeMap = new TreeMap<>();
        treeMap = getBottomView(root, 0, treeMap);
        for (Map.Entry<Integer, Integer> entry: treeMap.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
    }

    private static Map<Integer, Integer> getBottomView(TreeNode root, int hd, Map<Integer, Integer> treeMap) {
        if (root == null)
            return treeMap;

        Queue<QueueNode> queue = new LinkedList<>();
        queue.add(new QueueNode(root, hd));

        while (!queue.isEmpty()) {
            QueueNode queueNode = queue.poll();
            TreeNode treeNode = queueNode.treeNode;
            int level = queueNode.hd;

            treeMap.put(level, treeNode.data);

            if (treeNode.left != null)
                queue.add(new QueueNode(treeNode.left, level - 1));

            if (treeNode.right != null)
                queue.add(new QueueNode(treeNode.right, level + 1));
        }
        return treeMap;
    }

}
