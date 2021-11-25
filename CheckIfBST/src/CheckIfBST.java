/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- projects: CheckIfBST
*- 23 Nov 2021 7:14 PM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
-------------------------------------------*/

public class CheckIfBST {

    private static class TreeNode {

        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode prev = null;

    public void inorderDFS(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderDFS(root.left);
        System.out.print(root.val + " ");
        inorderDFS(root.right);
    }

    public boolean checkBST(TreeNode root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean checkBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        if (root.val >= max || root.val <= min) {
            return false;
        }
        return checkBST(root.left, min, root.val) && checkBST(root.right, root.val, max);
    }

    public static void main(String[] args) {
        CheckIfBST obj = new CheckIfBST();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        obj.inorderDFS(root);
        System.out.println();
        System.out.println(obj.checkBST(root));
    }
}
