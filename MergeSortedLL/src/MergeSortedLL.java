/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 22 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/MergeSortedLL
 * https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem
 */
public class MergeSortedLL {

    private static class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static void main(String[] args) {
        Node headA = null;
        Node headB = null;
        headA = insert(headA, 1);
        headB = insert(headB, 2);
        headA = insert(headA, 3);
        headB = insert(headB, 4);
        headA = insert(headA, 5);
        headB = insert(headB, 6);
        printList(headA);
        printList(headB);
        printList(mergeLists(headA, headB));
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

    private static Node mergeLists(Node headA, Node headB) {
        if (headA == null)
            return headB;

        if (headB == null)
            return headA;

        if (headA.data < headB.data) {
            headA.next = mergeLists(headA.next, headB);
            return headA;
        } else {
            headB.next = mergeLists(headB.next, headA);
            return headB;
        }
    }

}
