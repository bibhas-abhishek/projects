import java.util.LinkedList;
import java.util.Queue;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 10 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/BinaryTreeToDLL
 **/
public class BinaryTreeToDLL {

    private static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }

    }

    private static Node head = null;

    private static Node prev = null;

    private static Node root = null;

    public static void main(String[] args) {
        /*Node root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);*/

        root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);

        printLevelOrder(root);
        System.out.println();

        convertBinaryTreeToDLL(root);
        printList(head);

        sortedDLLToMinHeap();
        printLevelOrder(root);
    }

    private static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + (temp.right != null ? "->" : ""));
            temp = temp.right;
        }
        System.out.println();
    }

    private static int getLength(Node head) {
        int count = 0;
        while (head != null) {
            count = count + 1;
            head = head.right;
        }
        return count;
    }

    private static void inorderDFS(Node root) {
        if (root == null)
            return;
        inorderDFS(root.left);
        System.out.print(root.data + " ");
        inorderDFS(root.right);
    }

    private static void convertBinaryTreeToDLL(Node root) {
        if (root == null)
            return;

        convertBinaryTreeToDLL(root.left);
        if (prev == null)
            head = root;
        else {
            root.left = prev;
            prev.right = root;
        }

        prev = root;
        convertBinaryTreeToDLL(root.right);
    }

    /*private static void sortedDLLtoBST() {
        sortedDLLtoBSTUtil(getLength(head));
    }

    private static Node sortedDLLtoBSTUtil(int n) {
        if (n <= 0)
            return null;

        Node left = sortedDLLtoBSTUtil(n / 2);
        Node root = head;
        root.left = left;
        head = head.right;
        root.right = sortedDLLtoBSTUtil(n - n / 2 - 1);
        return root;
    }*/

    private static void sortedDLLToMinHeap() {
        if (head == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        root = head;
        head = head.right;
        root.right = null;
        queue.add(root);
        while (head != null) {
            Node parent = queue.poll();
            Node leftChild = head;
            head = head.right;
            leftChild.right = null;
            queue.add(leftChild);
            parent.left = leftChild;

            if (head != null) {
                Node rightChild = head;
                head = head.right;
                rightChild.right = null;
                queue.add(rightChild);
                parent.right = rightChild;
            }
        }
    }

    private static void printLevelOrder(Node root) {
        for (int i = 0; i <= height(root); i++) {
            printLevel(root, i);
        }
    }

    private static void printLevel(Node root, int level) {
        if (root == null)
            return;
        if (level == 0)
            System.out.print(root.data + " ");
        else {
            printLevel(root.left, level - 1);
            printLevel(root.right, level - 1);
        }
    }

    private static int height(Node root) {
        if (root == null)
            return -1;
        else
            return Math.max(height(root.left), height(root.right)) + 1;
    }

}
