/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 17 Oct 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/LinkedListPairSwap
 */

public class LinkedListPairSwap {

    private static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + (temp.next != null ? "->" : ""));
            temp = temp.next;
        }
        System.out.println();
    }

    public Node insert(Node head, int data) {
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

    /*public Node pairWiseSwap(Node head) {
        if (head == null || head.next == null)
            return head;

        Node C = head.next;
        Node P = head;
        head = C;
        while (true) {
            Node N = C.next;
            C.next = P;
            if (N == null || N.next == null) {
                P.next = N;
                break;
            }

            P.next = N.next;
            P = N;
            C = P.next;
        }
        return head;
    }*/

    public Node pairWiseSwap(Node head) {
        if (head == null || head.next == null)
            return head;

        Node remaining = head.next.next;
        Node newHead = head.next;
        head.next.next = head;
        head.next = pairWiseSwap(remaining);
        return newHead;
    }

    public static void main(String[] args) {
        LinkedListPairSwap obj = new LinkedListPairSwap();
        Node head = null;
        head = obj.insert(head, 1);
        head = obj.insert(head, 2);
        head = obj.insert(head, 3);
        head = obj.insert(head, 4);
        head = obj.insert(head, 5);
        head = obj.insert(head, 6);
        head = obj.insert(head, 7);

        obj.printList(head);
        head = obj.pairWiseSwap(head);
        obj.printList(head);
    }

}
