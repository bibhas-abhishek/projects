/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 20 Oct 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/AVLTree
 */

public class AVLTree {

    private static class Node {

        int val;
        Node left;
        Node right;
        int ht;

        Node(int val) {
            this.val = val;
            ht = 0;
        }

    }

    public void preorderTraversal(Node root) {
        if (root == null)
            return;

        System.out.print(root.val + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    private int getHeight(Node root) {
        if (root == null)
            return -1;

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    private int getBalanceFactor(Node root) {
        if (root == null)
            return 0;

        return getHeight(root.left) - getHeight(root.right);
    }

    private Node rightRotate(Node z) {
        Node y = z.left;
        Node temp = y.right;
        y.right = z;
        z.left = temp;
        y.ht = getHeight(y);
        z.ht = getHeight(z);
        return y;
    }

    private Node leftRotate(Node z) {
        Node y = z.right;
        Node temp = y.left;
        y.left = z;
        z.right = temp;
        y.ht = getHeight(y);
        z.ht = getHeight(z);
        return y;
    }

    public Node insertNode(Node root, int key) {
        if (root == null)
            return (new Node(key));

        if (key < root.val)
            root.left = insertNode(root.left, key);
        else if (key > root.val)
            root.right = insertNode(root.right, key);
        else
            return root;

        root.ht = getHeight(root);
        int balanceFactor = getBalanceFactor(root);

        // RR case. Left Rotate only
        if (balanceFactor < -1 && key > root.right.val) {
            return leftRotate(root);
        }

        // RL case. Right rotate. Then left rotate
        if (balanceFactor < -1 && key < root.right.val) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        // LL case. Right rotate only
        if (balanceFactor > 1 && key < root.left.val) {
            return rightRotate(root);
        }

        // LR case. Left Rotate. Then right rotate
        if (balanceFactor > 1 && key > root.left.val) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        return root;
    }

    private Node findMin(Node root) {
        while (root.left != null)
            root = root.left;

        return root;
    }

    public Node deleteNode(Node root, int key) {
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
                Node temp = root;
                root = root.left;
                temp = null;
            } else if (root.left == null) { // right child only
                Node temp = root;
                root = root.right;
                temp = null;
            } else {
                Node temp = findMin(root.right);
                root.val = temp.val;
                root.right = deleteNode(root.right, temp.val);
            }
        }

        if (root == null)
            return root;

        root.ht = getHeight(root);
        int balanceFactor = getBalanceFactor(root);

        // RR case. Left Rotate only
        if (balanceFactor < -1 && getBalanceFactor(root.right) <= 0) {
            return leftRotate(root);
        }

        //RL case. Right rotate. Then left rotate.
        if (balanceFactor < -1 && getBalanceFactor(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        //LL case. Right rotate only
        if (balanceFactor > 1 && getBalanceFactor(root.left) >= 0) {
            return rightRotate(root);
        }

        //LR case. Left Rotate. Then right rotate.
        if (balanceFactor > 1 && getBalanceFactor(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        return root;
    }

    public static void main(String[] args) {
        AVLTree obj = new AVLTree();
        Node root = null;
        root = obj.insertNode(root, 9);
        root = obj.insertNode(root, 5);
        root = obj.insertNode(root, 10);
        root = obj.insertNode(root, 0);
        root = obj.insertNode(root, 6);
        root = obj.insertNode(root, 11);
        root = obj.insertNode(root, -1);
        root = obj.insertNode(root, 1);
        root = obj.insertNode(root, 2);

        obj.preorderTraversal(root);
        System.out.println();
        root = obj.deleteNode(root, 10);
        obj.preorderTraversal(root);
    }

}
