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

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);

        convertBinaryTreeToDLL(root);
        printList(head);
    }

    private static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + (temp.right != null ? "->" : ""));
            temp = temp.right;
        }
        System.out.println();
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

}
