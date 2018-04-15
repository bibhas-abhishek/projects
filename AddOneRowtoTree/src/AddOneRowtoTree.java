import java.util.LinkedList;
import java.util.Queue;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 15 Apr 2018
 * https://leetcode.com/problems/add-one-row-to-tree/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/AddOneRowtoTree
 **/

public class AddOneRowtoTree {

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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(5);
        printLevelOrder(root);
        System.out.println();
        root = addOneRow(root, 1, 3);
        printLevelOrder(root);
        System.out.println();
    }

    private static TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d < 1)
            return root;

        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        addOneRowUtil(root, v, d, 1);
        return root;
    }

    private static void addOneRowUtil(TreeNode root, int v, int d, int n) {
        if (root == null)
            return;

        if (n == d - 1) {
            TreeNode temp = root.left;
            root.left = new TreeNode(v);
            root.left.left = temp;

            temp = root.right;
            root.right = new TreeNode(v);
            root.right.right = temp;
        }

        addOneRowUtil(root.left, v, d, n + 1);
        addOneRowUtil(root.right, v, d, n + 1);
    }

}
