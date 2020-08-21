public class LinkedList {

    static class Node {

        int  data;
        Node next;

        Node() {
        }

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        static void prettyPrintList(Node head) {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + (temp.next != null ? "->" : ""));
                temp = temp.next;
            }
            System.out.println();
        }
    }

    Node head;
    Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void prettyPrintList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + (temp.next != null ? "->" : ""));
            temp = temp.next;
        }
        System.out.println();
    }

    public void insertAtHead(int data) {
        Node temp = new Node(data);
        if (head == null) {
            tail = temp;
        }
        else {
            temp.next = head;
        }
        head = temp;
    }

    public void insertAtTail(int data) {
        Node temp = new Node(data);
        if (tail == null) {
            head = temp;
        }
        else {
            tail.next = temp;
        }
        tail = temp;
    }
}
