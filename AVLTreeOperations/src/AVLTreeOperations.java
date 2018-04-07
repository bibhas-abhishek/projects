/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 06 Apr 2018
 * https://www.hackerrank.com/challenges/self-balancing-tree/problem
 * https://github.com/bibhas-abhishek/projects/tree/master/AVLTreeOperations
 **/

public class AVLTreeOperations {

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

    public static void main(String[] args) {
        Node root = null;
        root = insertNode(root, 9);
        root = insertNode(root, 5);
        root = insertNode(root, 10);
        root = insertNode(root, 0);
        root = insertNode(root, 6);
        root = insertNode(root, 11);
        root = insertNode(root, -1);
        root = insertNode(root, 1);
        root = insertNode(root, 2);
        preorderDFS(root);
        System.out.println();
        root = deleteNode(root, 10);
        preorderDFS(root);
    }

    private static void preorderDFS(Node root) {
        if (root == null)
            return;

        System.out.print(root.val + " ");
        preorderDFS(root.left);
        preorderDFS(root.right);
    }

    private static int getHeight(Node root) {
        if (root == null)
            return -1;
        else
            return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    private static int getBalanceFactor(Node root) {
        if (root == null)
            return 0;
        else
            return getHeight(root.left) - getHeight(root.right);
    }

    private static Node leftRotate(Node l2) {
        Node l1 = l2.right;
        Node subTree = l1.left;
        l1.left = l2;
        l2.right = subTree;

        l1.ht = getHeight(l1);
        l2.ht = getHeight(l2);

        return l1; // new root
    }

    private static Node rightRotate(Node l2) {
        Node l1 = l2.left;
        Node subTree = l1.right;
        l1.right = l2;
        l2.left = subTree;

        l1.ht = getHeight(l1);
        l2.ht = getHeight(l2);

        return l1; // new root
    }

    private static Node insertNode(Node root, int key) {
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

        //RL case. Right rotate. Then left rotate.
        if (balanceFactor < -1 && key < root.right.val) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        //LL case. Right rotate only
        if (balanceFactor > 1 && key < root.left.val) {
            return rightRotate(root);
        }

        //LR case. Left Rotate. Then right rotate.
        if (balanceFactor > 1 && key > root.left.val) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        return root;
    }

    private static Node findMin(Node root) {
        while (root.left != null)
            root = root.left;

        return root;
    }

    private static Node deleteNode(Node root, int key) {
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

}
