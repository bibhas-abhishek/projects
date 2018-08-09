/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 08 Aug 2018
 * https://leetcode.com/problems/middle-of-the-linked-list/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/MidpointLinkedList
 */

public class MidpointLinkedList {

    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    private static ListNode middleNode(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode slowPtr = head, fastPtr = head.next;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return fastPtr != null ? slowPtr.next : slowPtr;
    }

    private static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + (temp.next != null ? "->" : ""));
            temp = temp.next;
        }
        System.out.println();
    }

    private static ListNode insert(ListNode head, int data) {
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

    public static void main(String[] args) {
        ListNode head = null;
        head = insert(head, 1);
        head = insert(head, 2);
        head = insert(head, 3);
        head = insert(head, 4);
        head = insert(head, 5);
        head = insert(head, 6);
        printList(head);
        System.out.println(middleNode(head).val);
    }

}
