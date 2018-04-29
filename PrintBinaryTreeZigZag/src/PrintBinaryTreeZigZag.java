/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 16 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/PrintBinaryTreeZigZag
 */
public class PrintBinaryTreeZigZag {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        printZigZagOrder(root);
    }

    private static void printZigZagOrder(TreeNode root) {
        boolean order = false;
        for (int i = 0; i <= height(root); i++) {
            printLevel(root, i, order);
            order = !order;
        }
    }

    private static void printLevel(TreeNode root, int level, boolean order) {
        if (root == null)
            return;
        if (level == 0)
            System.out.print(root.val + " ");
        else if (!order) {
            printLevel(root.right, level - 1, order);
            printLevel(root.left, level - 1, order);
        } else {
            printLevel(root.left, level - 1, order);
            printLevel(root.right, level - 1, order);
        }
    }

    private static int height(TreeNode root) {
        if (root == null)
            return -1;
        else
            return Math.max(height(root.left), height(root.right)) + 1;
    }

}
