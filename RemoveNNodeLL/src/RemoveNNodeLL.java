/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 28 Mar 2018
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/RemoveNNode
 **/
public class RemoveNNodeLL {

    private static class ListNode {

        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }

    }

    static int count;

    public static void main(String[] args) {
        ListNode head = null;
        head = insertAtHead(head, 1);
        head = insertAtHead(head, 2);
        /*head = insertAtHead(head, 3);
        head = insertAtHead(head, 4);
        head = insertAtHead(head, 5);
        head = insertAtHead(head, 6);*/
        printList(head);
        ListNode res = deleteNthNode(head, 1);
        printList(res);
    }

    private static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + (temp.next != null ? "->" : ""));
            temp = temp.next;
        }
        System.out.println();
    }

    private static ListNode insertAtHead(ListNode head, int data) {
        if (head == null)
            head = new ListNode(data);
        else {
            ListNode temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = new ListNode(data);
        }

        return head;
    }

    private static ListNode findNMinus1Node(ListNode head, int n) {
        if (head == null)
            return null;
        ListNode res = findNMinus1Node(head.next, n);
        if (++count == n + 1)
            return head;
        return res;
    }

    private static ListNode deleteNthNode(ListNode head, int n) {
        if (head == null)
            return null;

        ListNode res = findNMinus1Node(head, n);
        if (res == null)
            head = head.next;
        else
            res.next = res.next.next;
        return head;
    }

}
