/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 22 Oct 2017
 * https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/MergeSortedLL
 */
public class MergeSortedLL {

    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }

    }

    public static void main(String[] args) {
        ListNode headA = null;
        ListNode headB = null;
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

    private static ListNode mergeLists(ListNode headA, ListNode headB) {
        if (headA == null)
            return headB;

        if (headB == null)
            return headA;

        if (headA.val < headB.val) {
            headA.next = mergeLists(headA.next, headB);
            return headA;
        } else {
            headB.next = mergeLists(headB.next, headA);
            return headB;
        }
    }

}
