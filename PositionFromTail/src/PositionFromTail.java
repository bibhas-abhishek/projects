/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 23 Dec 2017
 **/

public class PositionFromTail {

    private static class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static void main(String[] args) {
        Node head = null;
        head = insert(head, 1);
        head = insert(head, 2);
        head = insert(head, 3);
        head = insert(head, 4);
        head = insert(head, 5);
        head = insert(head, 6);
        printList(head);
        System.out.print(getNode(head, length(head), 1, 3).data);
    }

    private static Node getNode(Node head, int length, int nodeCount, int positionFromTail) {
        if (head == null)
            return null;
        Node res = getNode(head.next, length, nodeCount + 1, positionFromTail);
        if (length - nodeCount == positionFromTail)
            return head;
        return res;
    }

    private static int length(Node head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }

        return length;
    }

    private static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + (temp.next != null ? "->" : ""));
            temp = temp.next;
        }
        System.out.println();
    }

    private static Node insert(Node head, int data) {
        if (head == null)
            head = new Node(data);
        else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = new Node(data);
        }

        return head;
    }

}

