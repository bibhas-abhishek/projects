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
        if (root == null) {
            return;
        }
        inorderDFS(root.left);
        System.out.print(root.val + " ");
        inorderDFS(root.right);
    }

    public TreeNode insertNode(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
        } else {
            if (key <= root.val) {
                root.left = insertNode(root.left, key);
            } else {
                root.right = insertNode(root.right, key);
            }
        }
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null) {// leaf node
                root = null;
            } else if (root.right == null) {// left child only
                root = root.left;
            } else if (root.left == null) {// right child only
                root = root.right;
            } else { // has both children
                TreeNode temp = findMin(root.right);
                root.val = temp.val;
                root.right = deleteNode(root.right, temp.val); // delete temp node
            }
        }
        return root;
    }

    private TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree driver = new BinarySearchTree();
        root = driver.insertNode(root, 10);
        root = driver.insertNode(root, 8);
        root = driver.insertNode(root, 3);
        root = driver.insertNode(root, 4);
        root = driver.insertNode(root, 9);
        root = driver.insertNode(root, 11);
        root = driver.insertNode(root, 14);
        root = driver.insertNode(root, 16);
        root = driver.insertNode(root, 19);
        root = driver.insertNode(root, 1);
        driver.inorderDFS(root);
        System.out.println();

        driver.deleteNode(root, 9);
        driver.inorderDFS(root);
        System.out.println();
    }
}
