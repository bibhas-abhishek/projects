/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 03 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/TestBed
 */
public class TestBed {

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

    private static int countMaxLevel = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        /*
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(getHeight(root));
        System.out.println(countNodes(root));
        */
        System.out.print(countNodes(root));
    }

    /*
    private static int getHeight(TreeNode root) {
        if (root == null)
            return -1;
        else
            return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    private static void findNodeCountAtLevel(TreeNode root, int level) {
        if (root == null)
            return;

        if (level == 0)
            countMaxLevel++;
        else {
            findNodeCountAtLevel(root.left, level - 1);
            findNodeCountAtLevel(root.right, level - 1);
        }
    }

    private static int countNodes(TreeNode root) {
        if (root == null)
            return -1;
        int getHeight = getHeight(root);
        int countMaxMinus1 = 0;
        if (getHeight == 0)
            return 1;

        for (int i = 0; i < getHeight; i++)
            countMaxMinus1 += (1 << i);

        findNodeCountAtLevel(root, getHeight);
        return countMaxMinus1 + countMaxLevel;
    }
    */

    public static int getHeight(TreeNode root) {
        if (root == null)
            return -1;
        else
            return 1 + getHeight(root.left);
    }

    public static int countNodes(TreeNode root) {
        int h = getHeight(root);
        if (h < 0)
            return 0;
        else {
            if (getHeight(root.right) == h - 1)
                return (1 << h) + countNodes(root.right); // last node is in right subTree. lefNodes + countRightNodes
            else
                return (1 << h - 1) + countNodes(root.left); //last node is in left subTree. rightNodes + countLeftNodes
        }
    }

}
