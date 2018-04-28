/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 28 Apr 2018
 * https://leetcode.com/problems/partition-list/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/PartitionList
 **/

public class PartitionList {

    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }

    }

    private static ListNode tail = null;

    public static void main(String[] args) {
        ListNode head = null;
        head = insertAtTail(head, 1);
        head = insertAtTail(head, 4);
        head = insertAtTail(head, 3);
        head = insertAtTail(head, 2);
        head = insertAtTail(head, 5);
        head = insertAtTail(head, 2);
        printList(head);
        partition(head, 3);
        printList(head);
    }

    private static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + (temp.next != null ? "->" : ""));
            temp = temp.next;
        }
        System.out.println();
    }

    private static ListNode insertAtTail(ListNode head, int data) {
        if (head == null) {
            head = new ListNode(data);
            tail = head;
        } else {
            ListNode temp = new ListNode(data);
            tail.next = temp;
            tail = temp;
            temp = null;
        }
        return head;
    }

    private static ListNode partition(ListNode head, int x) {
        // d for dummy
        ListNode dHead1 = new ListNode(Integer.MIN_VALUE);
        ListNode dHead2 = new ListNode(Integer.MIN_VALUE);
        ListNode dTail1 = dHead1;
        ListNode dTail2 = dHead2;
        while (head != null) {
            if (head.val < x) {
                dTail1.next = head;
                dTail1 = head;
            } else {
                dTail2.next = head;
                dTail2 = head;
            }
            head = head.next;
        }

        dTail2.next = null;
        dTail1.next = dHead2.next;
        return dHead1.next;
    }

}
