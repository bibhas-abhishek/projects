/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 03 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/DeleteNodeBST
 **/

public class DeleteNodeBST {

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
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(9);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(15);
        root.right.left.right = new TreeNode(12);
        root.right.right.right = new TreeNode(16);
        inorderDFS(root); System.out.println();
        deleteNode(root, 9);
        inorderDFS(root); System.out.println();
    }

    private static void inorderDFS(TreeNode root) {
        if (root == null)
            return;
        inorderDFS(root.left);
        System.out.print(root.val + " ");
        inorderDFS(root.right);
    }

    private static TreeNode findMin(TreeNode root) {
        while (root.left != null)
            root = root.left;

        return root;
    }

    private static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (key < root.val)
            root.left = deleteNode(root.left, key);
        else if (key > root.val)
            root.right = deleteNode(root.right, key);
        else {
            if (root.left == null && root.right == null) {  // leaf node
                root = null;
            } else if (root.right == null) { // left child only
                TreeNode temp = root;
                root = root.left;
                temp = null;
            } else if (root.left == null) { // right child only
                TreeNode temp = root;
                root = root.right;
                temp = null;
            } else {
                TreeNode temp = findMin(root.right);
                root.val = temp.val;
                root.right = deleteNode(root.right, temp.val);
            }
        }
        return root;
    }

}
