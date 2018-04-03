/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 03 Apr 2018
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/PairwiseSwapLL
 **/

public class PairwiseSwapLL {

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
        head = pairWiseSwapRec(head);
        printList(head);
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

    private static Node pairWiseSwap(Node head) {
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
    }

    private static Node pairWiseSwapRec(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node remaining = head.next.next;
        Node newHead = head.next;
        head.next.next = head;
        head.next = pairWiseSwap(remaining);
        return newHead;
    }

}
