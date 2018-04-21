/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 21 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/ConstructStringFromBinaryTree
 **/

public class ConstructStringFromBinaryTree {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

    }

    private static String tree2str(TreeNode t) {
        if (t == null)
            return "";
        else if (t.left == null && t.right == null)
            return t.val + "";
        else if (t.right == null)
            return t.val + "(" + tree2str(t.left) + ")";
        else
            return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(tree2str(root));
    }

}
