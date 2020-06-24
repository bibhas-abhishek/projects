/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 08 Oct 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/BinarySearchTree
 */

public class BinarySearchTree {

    private static class TreeNode {

        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    private static TreeNode root;

    public void inorderDFS(TreeNode root) {
        if (root == null)
            return;
        inorderDFS(root.left);
        System.out.print(root.val + " ");
        inorderDFS(root.right);
    }

    public TreeNode insertNode(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
        }
        else {
            if (key <= root.val)
                root.left = insertNode(root.left, key);
            else
                root.right = insertNode(root.right, key);
        }
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (key < root.val)
            root.left = deleteNode(root.left, key);
        else if (key > root.val)
            root.right = deleteNode(root.right, key);
        else {
            if (root.left == null && root.right == null) // leaf node
                root = null;
            else if (root.right == null) // left child only
                root = root.left;
            else if (root.left == null) // right child only
                root = root.right;
            else { // has both children
                TreeNode temp = findMin(root.right);
                root.val = temp.val;
                root.right = deleteNode(root.right, temp.val); // delete temp node
            }
        }
        return root;
    }

    private TreeNode findMin(TreeNode root) {
        while (root.left != null)
            root = root.left;
        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree obj = new BinarySearchTree();
        root = obj.insertNode(root, 10);
        root = obj.insertNode(root, 8);
        root = obj.insertNode(root, 3);
        root = obj.insertNode(root, 4);
        root = obj.insertNode(root, 9);
        root = obj.insertNode(root, 11);
        root = obj.insertNode(root, 14);
        root = obj.insertNode(root, 16);
        root = obj.insertNode(root, 19);
        root = obj.insertNode(root, 1);
        obj.inorderDFS(root);
        System.out.println();

        obj.deleteNode(root, 9);
        obj.inorderDFS(root);
        System.out.println();
    }
}
