/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 25 Mar 2018
 * https://leetcode.com/problems/add-two-numbers/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/AddLinkedLists1
 **/

public class AddLinkedLists1 {

    private static class Node {

        int data;
        Node next;

        Node() {
        }

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        void setData(int data) {
            this.data = data;
        }

        void setNext(Node next) {
            this.next = next;
        }

    }

    public static void main(String[] args) {
        Node head1 = null;
        head1 = insert(head1, 5);
        /*head1 = insert(head1, 4);
        head1 = insert(head1, 3);*/
        printList(head1);

        Node head2 = null;
        head2 = insert(head2, 5);
        /*head2 = insert(head2, 6);
        head2 = insert(head2, 4);*/
        printList(head2);

        Node head3 = addTwoNumbers(head1, head2);
        printList(head3);
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

    private static Node addTwoNumbers(Node l1, Node l2) {
        return addTwoLists(l1, l2, 0);
    }

    private static Node addTwoLists(Node l1, Node l2, int carry) {
        if (l1 == null && l2 == null && carry == 0)
            return null;

        Node n = new Node();
        int val = carry;
        if (l1 != null)
            val += l1.data;

        if (l2 != null)
            val += l2.data;

        n.setData(val % 10);
        Node list = addTwoLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next, val >= 10 ? 1 : 0);
        n.setNext(list);
        return n;
    }

}
